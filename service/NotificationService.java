package com.notification.service;

import com.notification.model.Notification;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service to manage notifications.
 */
public class NotificationService {
    // List to hold notifications (simulate database)
    private List<Notification> notificationList = new ArrayList<>();

    /**
     * Creates and stores a new notification.
     * @param userId The ID of the user receiving the notification.
     * @param message The content of the notification.
     */
    public void createNotification(int userId, String message) {
        Notification notification = new Notification(
            notificationList.size() + 1, // Simulated auto-increment ID
            userId,
            message,
            LocalDateTime.now()
        );
        notificationList.add(notification);
        System.out.println("Notification created: " + message);
    }

    /**
     * Retrieves notifications for a specific user.
     * @param userId The ID of the user.
     * @return List of notifications for the user.
     */
    public List<Notification> getNotificationsForUser(int userId) {
        List<Notification> userNotifications = new ArrayList<>();
        for (Notification notification : notificationList) {
            if (notification.getUserId() == userId) {
                userNotifications.add(notification);
            }
        }
        return userNotifications;
    }
}
