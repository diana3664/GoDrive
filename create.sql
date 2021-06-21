-- How the database is structured
CREATE DATABASE godrive;
\c godrive;
CREATE TABLE users (id serial PRIMARY KEY,username VARCHAR,phone_no VARCHAR, location VARCHAR, driver_name VARCHAR, price INT);