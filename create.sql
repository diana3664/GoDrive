-- How the database is structured
CREATE DATABASE godrive;
\c godrive;
CREATE TABLE users (id serial PRIMARY KEY,username VARCHAR,phone_no VARCHAR, location VARCHAR,driver_name VARCHAR,price INT);
CREATE TABLE drivers (id serial PRIMARY KEY,driver_name VARCHAR);
CREATE TABLE locations(id serial PRIMARY KEY, location VARCHAR, price INT);
CREATE TABLE ratings(id serial PRIMARY KEY,driver_name VARCHAR,comment VARCHAR,review INT);

