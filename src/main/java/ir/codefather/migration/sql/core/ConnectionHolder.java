package ir.codefather.migration.sql.core;

import java.sql.Connection;

public class ConnectionHolder {
    private final static ConnectionHolder connectionHolder = new ConnectionHolder();

    /**
     * database connection
     */
    private Connection connection;

    private ConnectionHolder() {
    }

    public static ConnectionHolder getInstance() {
        return connectionHolder;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
