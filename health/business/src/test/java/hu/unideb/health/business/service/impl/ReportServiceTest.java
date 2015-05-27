package hu.unideb.health.business.service.impl;

import hu.unideb.health.shared.exception.ExistingUserException;
import hu.unideb.health.shared.exception.UserNotFoundException;
import hu.unideb.health.shared.vo.ReportIndexDataVO;
import hu.unideb.health.shared.vo.ReportVO;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toth
 */
public class ReportServiceTest {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserDataServiceImpl.class);

    @AfterClass
    public static void tearDownClass() {
        clearDb();
    }

    public static void clearDb() {
        try (Connection connection = ConnectionUtil.createConnection()) {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeQuery("delete from user_indexes");
            }
            connection.commit();
            try (Statement stmt = connection.createStatement()) {
                stmt.executeQuery("delete from user_attributes");

            }
            connection.commit();
            try (Statement stmt = connection.createStatement()) {
                stmt.executeQuery("delete from user");
            }
            connection.commit();
        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

    @BeforeClass
    public static void setUpClass() {
        clearDb();
        UserVO testUser = new UserVO();
        testUser.setName("test_user");
        testUser.setPassword("test_pwd");

        UserAttributeVO testUserAttribute = new UserAttributeVO();
        testUserAttribute.setBirthDate(new Date());
        testUserAttribute.setCreationDate(new Date());
        testUserAttribute.setGender("férfi");
        testUserAttribute.setHeight(200);
        testUserAttribute.setUserAttributeId(1);
        testUserAttribute.setUserId(1);
        testUserAttribute.setWaist(100);
        testUserAttribute.setWeight(100);

        try {
            UserVO user = UserDataServiceImpl.getInstance().createUser(testUser, testUserAttribute);
        } catch (ExistingUserException ex) {
            logger.error(ex.getMessage(), ex);
            throw new AssertionError(ex.getMessage(), ex);
        }

    }

    @Test
    public void reportTest() {

        UserVO testUser = null;
        try {
            testUser = UserDataServiceImpl.getInstance().findByNameAndPassword("test_user", "test_pwd");
        } catch (UserNotFoundException ex) {
            logger.error(ex.getMessage(), ex);
        }

        ReportVO testResult = ReportServiceImpl.getInstance().findAllIndexesByUserId(testUser.getId());
        assertEquals("test_user", testResult.getUsername());

        List<ReportIndexDataVO> resultList = testResult.getData();

    }

    @Test
    public void bmiIndexReportTest() {

        UserVO testUser = null;
        try {
            testUser = UserDataServiceImpl.getInstance().findByNameAndPassword("test_user", "test_pwd");
        } catch (UserNotFoundException ex) {
            logger.error(ex.getMessage(), ex);
        }

        ReportVO testResult = ReportServiceImpl.getInstance().findAllIndexesByUserId(testUser.getId());
        List<ReportIndexDataVO> resultList = testResult.getData();
        assertEquals((double) 25, resultList.get(0).getBmi(), 1);
    }

    @Test
    public void whtrIndexReportTest() {

        UserVO testUser = null;
        try {
            testUser = UserDataServiceImpl.getInstance().findByNameAndPassword("test_user", "test_pwd");
        } catch (UserNotFoundException ex) {
            logger.error(ex.getMessage(), ex);
        }

        ReportVO testResult = ReportServiceImpl.getInstance().findAllIndexesByUserId(testUser.getId());
        List<ReportIndexDataVO> resultList = testResult.getData();

        assertEquals((double) 0.5, resultList.get(0).getWhtr(), 1);
    }

}
