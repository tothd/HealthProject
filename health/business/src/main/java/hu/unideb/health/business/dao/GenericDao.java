package hu.unideb.health.business.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface GenericDao<T extends Serializable> {
	
	void insert(T instance) throws SQLException;
	
	void update(T instance) throws SQLException;
	
	void delete(T instance) throws SQLException;

}
