CREATE DATABASE club

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	email TEXT NOT NULL UNIQUE,
	password text NOT NULL
)

CREATE TABLE admins (
	admin_id SERIAL PRIMARY KEY,
	user_id INT REFERENCES users(user_id),
	salary INT
)

