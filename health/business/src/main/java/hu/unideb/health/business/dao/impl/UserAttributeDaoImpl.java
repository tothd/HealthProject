package hu.unideb.health.business.dao.impl;

import hu.unideb.health.business.calculator.CalculateBMI;
import hu.unideb.health.business.calculator.CalculateBSI;
import hu.unideb.health.business.calculator.CalculateWHtR;
import hu.unideb.health.business.dao.AbstractGenericDao;
import hu.unideb.health.business.dao.DaoFactory;
import hu.unideb.health.business.dao.UserAttributeDao;
import hu.unideb.health.business.dao.UserIndexesDao;
import hu.unideb.health.shared.vo.UserAttributeVO;
import hu.unideb.health.shared.vo.UserIndexesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserAttributeDaoImpl extends AbstractGenericDao<UserAttributeVO> implements UserAttributeDao {

    private static final String DATE_FORMAT = "yyyy.MM.dd HH:mm:ss:SSS";

    public UserAttributeDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    protected String getInsertSql() {
        return "insert into user_attributes (height, weight,waist,creationdate,user_fk,birth_date,gender) values (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public Long insert(UserAttributeVO userAttributeVO) throws SQLException {
        
        Long userAttributeId=super.insert(userAttributeVO);
        
        double bmi=CalculateBMI.getInstance().calulateIndex(userAttributeVO);
        double bsi=CalculateBSI.getInstance().calulateIndex(userAttributeVO);
        double whtr=CalculateWHtR.getInstance().calulateIndex(userAttributeVO);
        
        
        UserIndexesVO userIndexesVO=new UserIndexesVO();
        userIndexesVO.setBmi(bmi);
        userIndexesVO.setBsi(bsi);
        userIndexesVO.setWhtr(whtr);
        userIndexesVO.setUserAttributeId(userAttributeId);
  
        UserIndexesDao userIndexesDao=DaoFactory.getInstance().getDao(this.conn, DaoFactory.DAO_TYPE.USER_INDEXES);
        
        userIndexesDao.insert(userIndexesVO);
                
        return userAttributeId;
        
    }
    
    @Override
    protected void setInsertVariable(PreparedStatement stmt, UserAttributeVO instance)
            throws SQLException {
        stmt.setInt(1, instance.getHeight());
        stmt.setInt(2, instance.getWeight());
        stmt.setInt(3, instance.getWaist());
        stmt.setString(4, new SimpleDateFormat(DATE_FORMAT).format(instance.getCreationDate()));
        stmt.setLong(5, instance.getUserId());
        stmt.setString(6,new SimpleDateFormat(DATE_FORMAT).format(instance.getBirthDate()));
        stmt.setString(7, instance.getGender());

    }

    @Override
    protected String getUpdateSql() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void setUpdateVariable(PreparedStatement stmt, UserAttributeVO instance) {
        // TODO Auto-generated method stub

    }

    @Override
    protected String getDeleteSql() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void setDeleteVariable(PreparedStatement stmt, UserAttributeVO instance) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserAttributeVO findLastByUser(long id) throws SQLException {
        UserAttributeVO result = null;
        try (PreparedStatement stmt = this.conn
                .prepareStatement("select * from user_attributes "+
         "join user on user.id=user_attributes."
                        + "user_fk where user.id = ? order by creationdate desc");) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next() && result == null) {
                result = new UserAttributeVO();
                result.setHeight(rs.getInt("height"));
                result.setWeight(rs.getInt("weight"));
                result.setWaist(rs.getInt("waist"));
                result.setCreationDate((new SimpleDateFormat(DATE_FORMAT).parse(rs.getString("creationdate"))));
                result.setBirthDate(new SimpleDateFormat(DATE_FORMAT).parse(rs.getString("birth_date")));
                result.setGender(rs.getString("gender"));
            }
        } catch (ParseException ex) {
            //TODO log
        }
        return result;
    }

}
