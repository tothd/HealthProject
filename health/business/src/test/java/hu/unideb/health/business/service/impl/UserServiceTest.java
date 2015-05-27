/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.service.impl;

import hu.unideb.health.shared.exception.ExistingUserException;
import hu.unideb.health.shared.exception.UserNotFoundException;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import hu.unideb.health.shared.vo.UserVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author toth
 */
public class UserServiceTest {

    public UserServiceTest() {
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
        testUserAttribute.setWaist(100);
        testUserAttribute.setWeight(100);

        try {
            UserVO user = UserDataServiceImpl.getInstance().createUser(testUser, testUserAttribute);
            assertEquals(testUser.getName(), user.getName());
        } catch (ExistingUserException ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

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
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFindByNameAndPassword() {
        try {
            UserVO testUser = UserDataServiceImpl.getInstance().findByNameAndPassword("test_user", "test_pwd");
            UserVO user = new UserVO();
            user.setId(testUser.getId());
            user.setName("test_user");
            user.setPassword("test_pwd");

            assertEquals(user.getName(), testUser.getName());
            assertEquals(user.getPassword(), testUser.getPassword());
        } catch (UserNotFoundException ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

    @Test
    public void testfindUserDataModificationById() {
        try {
            UserVO testUser = UserDataServiceImpl.getInstance().findByNameAndPassword("test_user", "test_pwd");
            UserAttributeVO testUserAttr = UserDataServiceImpl.getInstance().findUserDataModificationById(testUser.getId());

            assertEquals(testUser.getId(), new Long(testUserAttr.getUserId()));

        } catch (UserNotFoundException ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

    @Test
    public void testfindIndexesById() {
        try {
            UserVO testUser = UserDataServiceImpl.getInstance().findByNameAndPassword("test_user", "test_pwd");
            UserIndexesVO testIndexes = UserDataServiceImpl.getInstance().findUserIndexesById(testUser.getId());

            assertEquals((double) 0.5, testIndexes.getWhtr(), 1);

        } catch (UserNotFoundException ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

    @Test
    public void testModifyAttribute() {
        try {
            UserVO testUser = UserDataServiceImpl.getInstance().findByNameAndPassword("test_user", "test_pwd");

            UserAttributeVO testUserAttribute = new UserAttributeVO();
            
            testUserAttribute.setBirthDate(new Date());
            testUserAttribute.setCreationDate(new Date());
            testUserAttribute.setGender("nő");
            testUserAttribute.setHeight(170);
            testUserAttribute.setWaist(77);
            testUserAttribute.setWeight(60);
            testUserAttribute.setUserId(testUser.getId());
            
            UserDataServiceImpl.getInstance().modifyUserAttribute(testUserAttribute);

            UserAttributeVO resultUserAttribute = UserDataServiceImpl.getInstance().findUserDataModificationById(testUser.getId());

            assertEquals(170, resultUserAttribute.getHeight());

            assertEquals("nő", resultUserAttribute.getGender());

        } catch (UserNotFoundException ex) {
            throw new AssertionError(ex.getMessage(), ex);
        }
    }

}
