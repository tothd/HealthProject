package hu.unideb.health.business.dao.impl;

import hu.unideb.health.business.dao.AbstractGenericDao;
import hu.unideb.health.business.dao.UserIndexesDao;
import hu.unideb.health.shared.vo.ReportIndexDataVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 * A kiszámított indexek adatbázis műveleteinek az implementációja.
 */
public class UserIndexesDaoImpl extends AbstractGenericDao<UserIndexesVO> implements UserIndexesDao {

    /**
     * Adatbázis kapcsolat megvalósításhoz használt metódus.
     * @param conn Connection típus, amivel kapcsolódunk adatbázishoz.
     */
    public UserIndexesDaoImpl(Connection conn) {
        super(conn);
    }

    /**
     * Loggoláshoz használt konstans.
     */
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserIndexesDaoImpl.class);

    /**
     * Dátum formázó konstans.
     */
    private static final String DATE_FORMAT = "yyyy.MM.dd HH:mm:ss:SSS";

    @Override
    public List<ReportIndexDataVO> findAllIndexesByUserId(long id) {

        if (logger.isDebugEnabled()) {
            logger.debug("User id parameter: " + id);
        }

        List<ReportIndexDataVO> reportList = new ArrayList<ReportIndexDataVO>();
        try (PreparedStatement stmt = this.conn.prepareStatement("Select bmi,bsi,whtr,creationdate from "
                + " user_indexes join user_attributes on "
                + " user_indexes.attribute_fk=user_attributes.id "
                + " join user on user.id=user_attributes.user_fk "
                + " where user.id=?")) {
            logger.info("Connection succesfull.");
            stmt.setLong(1, id);
            try (ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    ReportIndexDataVO reportIndexes = new ReportIndexDataVO();
                    reportIndexes.setBmi(rset.getDouble("BMI"));
                    reportIndexes.setBsi(rset.getDouble("BSI"));
                    reportIndexes.setWhtr(rset.getDouble("WHTR"));

                    try {
                        reportIndexes.setCreationDate(new SimpleDateFormat(DATE_FORMAT).parse(rset.getString("creationdate")));
                    } catch (ParseException ex) {

                        logger.error(ex.getMessage(), ex);
                    }

                    reportList.add(reportIndexes);
                }
            }

        } catch (SQLException ex) {
            logger.info("Connection unsuccesfull.");
            logger.error(ex.getMessage(), ex);
        }

        return reportList;
    }

    @Override
    protected String getInsertSql() {
        return "insert into user_indexes (bmi, bsi,whtr,attribute_fk) values (?, ?, ?, ?)";
    }

    @Override
    protected void setInsertVariable(PreparedStatement stmt, UserIndexesVO instance) throws SQLException {
        stmt.setDouble(1, instance.getBmi());
        stmt.setDouble(2, instance.getBsi());
        stmt.setDouble(3, instance.getWhtr());
        stmt.setLong(4, instance.getUserAttributeId());

    }

    @Override
    protected String getUpdateSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setUpdateVariable(PreparedStatement stmt, UserIndexesVO instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getDeleteSql() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setDeleteVariable(PreparedStatement stmt, UserIndexesVO instance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserIndexesVO findUserIndexesByAttributeId(long id) {
        UserIndexesVO userIndexesVO = new UserIndexesVO();
        try (PreparedStatement stmt = this.conn.prepareStatement("Select bmi,bsi,whtr "
                + " from user_indexes join user_attributes on "
                + " user_indexes.attribute_fk=user_attributes.id "
                + " where user_attributes.id=?")) {
            stmt.setLong(1, id);
            try (ResultSet rset = stmt.executeQuery()) {
                while (rset.next()) {
                    userIndexesVO.setBmi(rset.getDouble("BMI"));
                    userIndexesVO.setBsi(rset.getDouble("BSI"));
                    userIndexesVO.setWhtr(rset.getDouble("WHTR"));
                    userIndexesVO.setUserAttributeId(id);
                }
            }
        } catch (SQLException ex) {
            logger.info("Connection unsuccesfull.");
            logger.error(ex.getMessage(), ex);
        }
        return userIndexesVO;
    }

}
