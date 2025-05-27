# Database Schema Creation

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled'),
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link'),
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

# Exercises

-- 1. User Upcoming Events
SELECT e.title, e.start_date 
FROM Events e 
JOIN Registrations r ON e.event_id = r.event_id 
JOIN Users u ON r.user_id = u.user_id 
WHERE e.status = 'upcoming' AND u.city = 'New York' 
ORDER BY e.start_date;

-- 2. Top Rated Events
SELECT e.title, AVG(f.rating) AS average_rating 
FROM Events e 
JOIN Feedback f ON e.event_id = f.event_id 
GROUP BY e.event_id 
HAVING COUNT(f.feedback_id) >= 10 
ORDER BY average_rating DESC;

-- 3. Inactive Users
SELECT * 
FROM Users 
WHERE user_id NOT IN (SELECT DISTINCT user_id FROM Registrations WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY));

-- 4. Peak Session Hours
SELECT e.title, COUNT(s.session_id) AS session_count 
FROM Events e 
JOIN Sessions s ON e.event_id = s.event_id 
WHERE TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00' 
GROUP BY e.event_id;

-- 5. Most Active Cities
SELECT city, COUNT(DISTINCT user_id) AS user_count 
FROM Users 
GROUP BY city 
ORDER BY user_count DESC 
LIMIT 5;

-- 6. Event Resource Summary
SELECT e.title, 
       SUM(CASE WHEN r.resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
       SUM(CASE WHEN r.resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
       SUM(CASE WHEN r.resource_type = 'link' THEN 1 ELSE 0 END) AS link_count
FROM Events e 
LEFT JOIN Resources r ON e.event_id = r.event_id 
GROUP BY e.event_id;

-- 7. Low Feedback Alerts
SELECT u.full_name, f.comments, e.title 
FROM Feedback f 
JOIN Users u ON f.user_id = u.user_id 
JOIN Events e ON f.event_id = e.event_id 
WHERE f.rating < 3;

-- 8. Sessions per Upcoming Event
SELECT e.title, COUNT(s.session_id) AS session_count 
FROM Events e 
LEFT JOIN Sessions s ON e.event_id = s.event_id 
WHERE e.status = 'upcoming' 
GROUP BY e.event_id;

-- 9. Organizer Event Summary
SELECT u.full_name, COUNT(e.event_id) AS event_count, e.status 
FROM Users u 
LEFT JOIN Events e ON u.user_id = e.organizer_id 
GROUP BY u.user_id;

-- 10. Feedback Gap
SELECT e.title 
FROM Events e 
LEFT JOIN Feedback f ON e.event_id = f.event_id 
WHERE f.feedback_id IS NULL AND e.event_id IN (SELECT DISTINCT event_id FROM Registrations);

-- 11. Daily New User Count
SELECT registration_date, COUNT(user_id) AS new_users 
FROM Users 
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) 
GROUP BY registration_date;

-- 12. Event with Maximum Sessions
SELECT e.title 
FROM Events e 
JOIN Sessions s ON e.event_id = s.event_id 
GROUP BY e.event_id 
ORDER BY COUNT(s.session_id) DESC 
LIMIT 1;

-- 13. Average Rating per City
SELECT u.city, AVG(f.rating) AS average_rating 
FROM Feedback f 
JOIN Events e ON f.event_id = e.event_id 
JOIN Registrations r ON e.event_id = r.event_id 
JOIN Users u ON r.user_id = u.user_id 
GROUP BY u.city;

-- 14. Most Registered Events
SELECT e.title, COUNT(r.registration_id) AS registration_count 
FROM Events e 
JOIN Registrations r ON e.event_id = r.event_id 
GROUP BY e.event_id 
ORDER BY registration_count DESC 
LIMIT 3;

-- 15. Event Session Time Conflict
SELECT s1.title AS session1, s2.title AS session2, e.title AS event_title 
FROM Sessions s1 
JOIN Sessions s2 ON s1.event_id = s2.event_id AND s1.session_id <> s2.session_id 
JOIN Events e ON s1.event_id = e.event_id 
WHERE (s1.start_time < s2.end_time AND s1.end_time > s2.start_time);

-- 16. Unregistered Active Users
SELECT * 
FROM Users 
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
AND user_id NOT IN (SELECT DISTINCT user_id FROM Registrations);

-- 17. Multi-Session Speakers
SELECT speaker_name, COUNT(session_id) AS session_count 
FROM Sessions 
GROUP BY speaker_name 
HAVING session_count > 1;

-- 18. Resource Availability Check
SELECT e.title 
FROM Events e 
LEFT JOIN Resources r ON e.event_id = r.event_id 
WHERE r.resource_id IS NULL;

-- 19. Completed Events with Feedback Summary
SELECT e.title, COUNT(r.registration_id) AS total_registrations, AVG(f.rating) AS average_rating 
FROM Events e 
JOIN Registrations r ON e.event_id = r.event_id 
JOIN Feedback f ON e.event_id = f.event_id 
WHERE e.status = 'completed' 
GROUP BY e.event_id;

-- 20. User Engagement Index
SELECT u.full_name, COUNT(DISTINCT r.event_id) AS events_attended, COUNT(f.feedback_id) AS feedback_submitted 
FROM Users u 
LEFT JOIN Registrations r ON u.user_id = r.user_id 
LEFT JOIN Feedback f ON u.user_id = f.user_id 
GROUP BY u.user_id;

-- 21. Top Feedback Providers
SELECT u.full_name, COUNT(f.feedback_id) AS feedback_count 
FROM Users u 
JOIN Feedback f ON u.user_id = f.user_id 
GROUP BY u.user_id 
ORDER BY feedback_count DESC 
LIMIT 5;

-- 22. Duplicate Registrations Check
SELECT user_id, event_id, COUNT(*) AS registration_count 
FROM Registrations 
GROUP BY user_id, event_id 
HAVING registration_count > 1;

-- 23. Registration Trends
SELECT DATE_FORMAT(registration_date, '%Y-%m') AS month, COUNT(user_id) AS registration_count 
FROM Users 
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH) 
GROUP BY month;

-- 24. Average Session Duration per Event
SELECT e.title, AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS average_duration 
FROM Events e 
JOIN Sessions s ON e.event_id = s.event_id 
GROUP BY e.event_id;

-- 25. Events Without Sessions
SELECT e.title 
FROM Events e 
LEFT JOIN Sessions s ON e.event_id = s.event_id 
WHERE s.session_id IS NULL;
