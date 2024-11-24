const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();  // Declare app once

// Enable CORS
app.use(cors());

// Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Database connection
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root', // Replace with your MySQL username
    password: 'Login123', // Replace with your MySQL password
    database: 'auth' // Replace with your database name
});

db.connect((err) => {
    if (err) {
        console.error('Database connection failed:', err.message);
    } else {
        console.log('Connected to the MySQL database.');
    }
});

// Login endpoint
app.post('/login', (req, res) => {
    const { username, password } = req.body;

    const query = 'SELECT * FROM users WHERE username = ? AND password = ?';
    db.query(query, [username, password], (err, results) => {
        if (err) {
            console.error(err);
            res.status(500).send('Internal server error');
        } else if (results.length > 0) {
            // Valid login
            res.json({ success: true });
        } else {
            // Invalid credentials
            res.status(401).send('Invalid username or password');
        }
    });
});



// API endpoint to save a task
app.post('/api/tasks', (req, res) => {
    const { title, description, priority, dueDate, assignee } = req.body;

    const query = `INSERT INTO tasks (title, description, priority, due_date, assignee) VALUES (?, ?, ?, ?, ?)`;
    db.query(query, [title, description, priority, dueDate, assignee], (err, result) => {
        if (err) {
            console.error('Error inserting task:', err);
            res.status(500).send('Failed to save task');
        } else {
            res.status(201).send('Task saved successfully');
        }
    });
});


// Start server
const port = 3000;
app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
