CREATE DATABASE bankDB;

USE bankDB;

BEGIN;

CREATE TABLE customers (
	id INT NOT NULL auto_increment,
	name VARCHAR(50) NOT NULL,
	userName VARCHAR(50) NOT NULL,
	pass VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE accounts (
	id int not null auto_increment,
	customer_id int not null,
	balance FLOAT,
	PRIMARY KEY (id),
	FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO customers (name, userName, pass, email) VALUES
	('James Albright', 'JamesA', 'secret', 'james@atu.ie'),
	('Kevin Holland', 'KevinH', 'hush1', 'kevin@atu.ie'),
	('Kerry Franklin', 'KerryF', 'neverguess', 'kerry@atu.ie'),
	('John Bradley', 'JohnB', 'goodluck', 'john@atu.ie');

INSERT INTO accounts (customer_id, balance) VALUES
	(1, 2300),
	(2, 5610),
	(3, 1023.56),
	(4, 23.65);

COMMIT;
