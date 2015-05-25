package hu.unideb.health.business.service.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Az adatbázis kapcsolatot megvalósító osztály.
 */
class ConnectionUtil {

    /**
     * Loggoláshoz használt konstans.
     */
    private static final Logger logger=LoggerFactory.getLogger(ConnectionUtil.class);
    
    /**
     * A jdbc url.
     */
    private static final String DB_FILE_NAME_PREFIX = "jdbc:hsqldb:hsql://localhost/healthdb";

    /**
     * Létrehoz egy adaztbázis kapcsolatot.
     *
     * @return Connection típusú változó.
     * @throws SQLException
     */
    static Connection createConnection() throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(),e);
        }
        Connection conn = DriverManager.getConnection(DB_FILE_NAME_PREFIX,
                "sa", // username
                ""); // password
        conn.setAutoCommit(false);
        return conn;
    }

}
