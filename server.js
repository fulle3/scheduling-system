// Import the required modules
const express = require('express');
const path = require('path');
const bodyParser = require('body-parser');
const { createNotification, getNotificationsForUser } = require('./notificationService');

// Initialize the Express app
const app = express();

// Use body-parser middleware to parse JSON requests
app.use(bodyParser.json());

// Serve static files (e.g., index.html)
app.use(express.static(path.join(__dirname)));

// Basic route for the root URL (already covered in your version)
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'index.html')); // Serve the HTML file
});

// Route to create a notification (use actual logic from notificationService.js)
app.post('/notifications', (req, res) => {
    const { userId, message } = req.body;
    if (!userId || !message) {
        return res.status(400).send('User ID and message are required');
    }
    createNotification(userId, message, (err, result) => {
        if (err) {
            return res.status(500).send('Error creating notification');
        }
        res.status(201).send('Notification created successfully!');
    });
});

// Route to get notifications for a specific user
app.get('/notifications/:userId', (req, res) => {
    const userId = parseInt(req.params.userId, 10);
    getNotificationsForUser(userId, (err, results) => {
        if (err) {
            return res.status(500).send('Error retrieving notifications');
        }
        res.json(results);
    });
});

// Start the server and listen on port 3000
app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
});
