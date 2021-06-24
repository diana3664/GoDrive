-- How the database is structured
CREATE DATABASE godrive;
\c godrive;


--creates users table
CREATE TABLE users (
id serial PRIMARY KEY,
username VARCHAR,
phone_no VARCHAR, location VARCHAR,
driver_name VARCHAR,
price INT);

--creates drivers table

CREATE TABLE drivers (
id serial PRIMARY KEY,
driver_name VARCHAR
);

CREATE DATABASE godrive_test WITH TEMPLATE godrive;
CREATE TABLE users (id serial PRIMARY KEY,username VARCHAR,phone_no VARCHAR, location VARCHAR, driver_name VARCHAR, price (INT);
CREATE TABLE locations(id serial PRIMARY KEY, location VARCHAR, price INT);
