package hu.unideb.health.business.dao;

import hu.unideb.health.shared.vo.UserAttributeVO;
import java.sql.SQLException;

import hu.unideb.health.shared.vo.UserVO;
import java.util.List;

public interface UserAttributeDao extends GenericDao<UserAttributeVO>{
	
	UserAttributeVO findLastByUser(long id) throws SQLException;

}
