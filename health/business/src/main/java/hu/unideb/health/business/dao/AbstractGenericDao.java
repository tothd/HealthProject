package hu.unideb.health.business.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Adatbázis műveleteknek a váza.
 * @param <T> Egy szerializálható oszály.
 */
public abstract class AbstractGenericDao<T extends Serializable> implements GenericDao<T> {

    protected final Connection conn;

    public AbstractGenericDao(Connection conn) {
        this.conn = conn;
    }

    public Long insert(T instance) throws SQLException {
        Long insertId = null;
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(getInsertSql(), Statement.RETURN_GENERATED_KEYS);
            setInsertVariable(stmt, instance);
            int rows = stmt.executeUpdate();
            conn.commit();
            if (rows == 0) {
                throw new SQLException("Unsucces insert");
            }
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                while (keys.next()) {
                    insertId = keys.getLong(1);
                }
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        if (insertId == null) {
            throw new SQLException("InsertId is null");
        }
        return insertId;
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
