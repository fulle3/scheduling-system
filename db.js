// Import the MySQL module to connect to the database
const mysql = require('mysql2');

console.log('Starting to create a database connection...');

// Create a connection object with the database configuration
const connection = mysql.createConnection({
    host: 'localhost', // The host of the database
    user: 'root', // Your MySQL username
    password: 'MySecurePass123', // Your MySQL password
    database: 'notification_system' // The database name
});

// Connect to the database and handle any errors
connection.connect((err) => {
    if (err) {
        console.error('Error connecting to the database:', err.stack);
        return;
    }
    console.log('Connected to the database.');
});

// Test query to check if the connection works properly
connection.query('SELECT 1 + 1 AS solution', (err, results) => {
    if (err) {
        console.error('Query failed:', err);
        return;
    }
    console.log('Query successful, result:', results[0].solution);
});

// Export the connection object so it can be used in other files
module.exports = connection;
