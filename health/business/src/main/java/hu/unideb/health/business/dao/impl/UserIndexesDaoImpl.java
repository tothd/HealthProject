/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.health.business.dao.impl;

import hu.unideb.health.business.dao.AbstractGenericDao;
import hu.unideb.health.business.dao.UserIndexesDao;
import hu.unideb.health.shared.vo.ReportIndexDataVO;
import hu.unideb.health.shared.vo.ReportVO;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toth
 */
public class UserIndexesDaoImpl extends AbstractGenericDao<UserIndexesVO> implements UserIndexesDao {

    public UserIndexesDaoImpl(Connection conn) {
        super(conn);
    }

    private static final String DATE_FORMAT = "yyyy.MM.dd HH:mm:ss:SSS";

    @Override
    public List<ReportIndexDataVO> findAllIndexesByUserId(long id) {

        List<ReportIndexDataVO> reportList = new ArrayList<ReportIndexDataVO>();
        try (PreparedStatement stmt = this.conn.prepareStatement("Select bmi,bsi,whtr,creationdate from "
                + " user_indexes join user_attributes on "
                + " user_indexes.attribute_fk=user_attributes.id "
                + " join user on user.id=user_attributes.user_fk "
                + " where user.id=?")) {
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
                        Logger.getLogger(UserIndexesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    reportList.add(reportIndexes);
                }
            }

        } catch (SQLException ex) {
            //TODO log
            ex.printStackTrace();
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

}
