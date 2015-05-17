package hu.unideb.health.business.dao;

import java.sql.SQLException;

import hu.unideb.health.shared.vo.UserVO;

public interface UserDao extends GenericDao<UserVO>{
	
	UserVO findByNameAndPassword(String name, String password) throws SQLException;

}
