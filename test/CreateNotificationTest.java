package com.notification.test;

import com.notification.service.NotificationService;

/**
 * Test to create and insert notifications into the database.
 */
public class CreateNotificationTest {
    public static void main(String[] args) {
        // Create an instance of NotificationService to call its methods.
        NotificationService notificationService = new NotificationService();
        
        // Create a notification for a specific user ID.
        notificationService.createNotification(1, "This is a test notification for user ID 1.");
        
        // Additional tests for other user IDs.
        notificationService.createNotification(2, "Test notification for user ID 2.");
        notificationService.createNotification(3, "Another test notification for user ID 3.");

        System.out.println("Notifications have been created.");
    }
}

