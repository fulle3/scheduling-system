package com.notification.ui;

import com.notification.service.NotificationService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User interface for the notification system.
 */
public class NotificationUI {
    private NotificationService notificationService = new NotificationService();

    public void showUI() {
        // Create a JFrame for the UI
        JFrame frame = new JFrame("In-App Notification System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(5, 1));

        // User ID input
        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField();
        panel.add(userIdLabel);
        panel.add(userIdField);

        // Message input
        JLabel messageLabel = new JLabel("Message:");
        JTextField messageField = new JTextField();
        panel.add(messageLabel);
        panel.add(messageField);

        // Button to create a notification
        JButton notifyButton = new JButton("Create Notification");
        panel.add(notifyButton);

        // Button action listener
        notifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int userId = Integer.parseInt(userIdField.getText());
                String message = messageField.getText();
                notificationService.createNotification(userId, message);
                JOptionPane.showMessageDialog(null, "Notification sent!");
            }
        });
    }

    public static void main(String[] args) {
        new NotificationUI().showUI();
    }
}
