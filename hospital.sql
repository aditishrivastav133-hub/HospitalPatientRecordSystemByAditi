CREATE DATABASE hospital;

USE hospital;

CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    disease VARCHAR(100),
    medical_history TEXT,
    phone VARCHAR(15)
);

CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

INSERT INTO users (username, password)
VALUES ('admin', 'admin123');