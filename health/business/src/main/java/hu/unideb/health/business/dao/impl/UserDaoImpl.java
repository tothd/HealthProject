package hu.unideb.health.business.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.unideb.health.business.dao.AbstractGenericDao;
import hu.unideb.health.business.dao.UserDao;
import hu.unideb.health.shared.vo.UserVO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDaoImpl extends AbstractGenericDao<UserVO> implements UserDao {

    public UserDaoImpl(Connection conn) {
        super(conn);
    }
    

    @Override
    protected String getInsertSql() {
        return "insert into user (name, password) values (?, ?)";
    }

    @Override
    protected void setInsertVariable(PreparedStatement stmt, UserVO instance)
            throws SQLException {
        stmt.setString(1, instance.getName());
        stmt.setString(2, instance.getPassword());
    }

    @Override
    protected String getUpdateSql() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void setUpdateVariable(PreparedStatement stmt, UserVO instance) {
        // TODO Auto-generated method stub

    }

    @Override
    protected String getDeleteSql() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void setDeleteVariable(PreparedStatement stmt, UserVO instance) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserVO findByNameAndPassword(String name, String password)
            throws SQLException {
        UserVO result = null;
        try (PreparedStatement stmt = this.conn
                .prepareStatement("select * from user where name = ? and password = ?");) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next() && result == null) {
                result = new UserVO();
                result.setId(rs.getLong("id"));
                result.setName(name);
                result.setPassword(password);
            }
        }
        return result;
    }

    @Override
    public UserVO findById(Long id) throws SQLException {
        UserVO result=null;
        try (PreparedStatement stmt=this.conn
                    .prepareStatement("select * from user where id= ?");){
            stmt.setLong(1, id);
            ResultSet rs=stmt.executeQuery();
            while(rs.next() && result==null){
                result=new UserVO();
                result.setId(id);
                result.setName(rs.getString("name"));
                result.setPassword(rs.getString("password"));
            }
        }
        return result;
    }
}
