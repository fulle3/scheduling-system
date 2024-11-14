package com.notification.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to handle database connections.
 */
public class DatabaseConnection {
    // Database URL and credentials
    private static final String URL = "jdbc:mysql://localhost:3306/notification_system";
    private static final String USER = "root"; // Replace with your actual MySQL username
    private static final String PASSWORD = "MySecurePass123"; // Replace with your actual MySQL password

    /**
     * Establishes and returns a connection to the database.
     * @return Connection object.
     * @throws SQLException if a connection error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
