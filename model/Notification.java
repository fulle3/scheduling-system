package com.notification.model;

import java.time.LocalDateTime;

/**
 * Represents a notification in the system.
 */
public class Notification {
    private int notificationId;  // Primary Key
    private int userId;          // Foreign Key referencing User
    private String message;      // Notification message content
    private LocalDateTime timestamp; // Time of notification

    // Constructor
    public Notification(int notificationId, int userId, String message, LocalDateTime timestamp) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public int getNotificationId() { return notificationId; }
    public int getUserId() { return userId; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setNotificationId(int notificationId) { this.notificationId = notificationId; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setMessage(String message) { this.message = message; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
