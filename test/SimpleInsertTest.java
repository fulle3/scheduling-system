package com.notification.test;

import com.notification.model.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A simple class to test database insertion and connection.
 */
public class SimpleInsertTest {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // SQL statement for inserting a new row
            String sql = "INSERT INTO notifications (user_id, message, timestamp) VALUES (1, 'Simple test notification', NOW())";
            
            // Prepare and execute the statement
            PreparedStatement statement = connection.prepareStatement(sql);
            int rowsInserted = statement.executeUpdate();
            
            // Check if the insertion was successful
            if (rowsInserted > 0) {
                System.out.println("A new notification was inserted successfully!");
            } else {
                System.out.println("Insertion failed.");
            }
        } catch (SQLException e) {
            // Print the stack trace to debug any SQL issues
            e.printStackTrace();
        }
    }
}
