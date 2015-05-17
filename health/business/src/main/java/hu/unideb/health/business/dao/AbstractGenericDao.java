package hu.unideb.health.business.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractGenericDao<T extends Serializable> implements GenericDao<T> {

	protected final Connection conn;

	public AbstractGenericDao(Connection conn) {
		this.conn = conn;
	}

	public void insert(T instance) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(getInsertSql());
			setInsertVariable(stmt, instance);
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
	}

	protected abstract String getInsertSql();

	protected abstract void setInsertVariable(PreparedStatement stmt, T instance) throws SQLException;

	public void update(T instance) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(getUpdateSql());
			setUpdateVariable(stmt, instance);
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
	}

	protected abstract String getUpdateSql();

	protected abstract void setUpdateVariable(PreparedStatement stmt, T instance);

	public void delete(T instance) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(getDeleteSql());
			setDeleteVariable(stmt, instance);
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
	}

	protected abstract String getDeleteSql();

	protected abstract void setDeleteVariable(PreparedStatement stmt, T instance);

}
