// Import the required modules
const express = require('express');
const bodyParser = require('body-parser');

// Initialize the Express app
const app = express();

// Use body-parser middleware to parse JSON requests
app.use(bodyParser.json());

// Basic route for the root URL
app.get('/', (req, res) => {
    res.send('Welcome to the Notification System!');
});

// Example route to handle a GET request for notifications
app.get('/notifications', (req, res) => {
    res.send('This is the notifications endpoint!');
});

// Example route to create a notification (placeholder logic)
app.post('/notifications', (req, res) => {
    const { userId, message } = req.body;
    console.log(`Received a notification request for user ${userId} with message: ${message}`);
    res.status(201).send('Notification created successfully!');
});

// Start the server and listen on port 3000
app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
});
