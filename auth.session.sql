use auth;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique ID for each user
    username VARCHAR(50) NOT NULL UNIQUE,  -- Username (must be unique)
    password VARCHAR(255) NOT NULL       -- Password (hashed for security)
);

INSERT INTO users (username, password)
VALUES 
    ('admin', 'admin123'),
    ('ayush', 'ayush123'),
    ('norden', 'norden123');

SELECT * FROM users;



CREATE TABLE completed_tasks (
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    priority ENUM('High', 'Medium', 'Low') NOT NULL,
    due_date DATE NOT NULL,
    assignee VARCHAR(50) NOT NULL
)

SELECT * FROM completed_tasks;


CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    priority ENUM('High', 'Medium', 'Low') NOT NULL,
    due_date DATE NOT NULL,
    assignee VARCHAR(255) NOT NULL,
    status ENUM('Pending', 'Completed') DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM tasks;
DROP TABLE tasks;

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    priority ENUM('High', 'Medium', 'Low') NOT NULL,
    due_date DATE NOT NULL,
    assignee VARCHAR(100) NOT NULL,
    is_completed BOOLEAN DEFAULT FALSE,
    is_approved BOOLEAN DEFAULT FALSE
);

