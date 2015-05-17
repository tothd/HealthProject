package hu.unideb.health.business.service.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionUtil {

    private static final String DB_FILE_NAME_PREFIX = "file:." + File.separator + "db"
            + File.separator + "healthdb";

    static Connection createConnection() throws SQLException {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            //TODO log
        }
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:"
                + DB_FILE_NAME_PREFIX, // filenames
                "sa", // username
                ""); // password
        conn.setAutoCommit(false);
        return conn;
    }

}
