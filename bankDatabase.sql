CREATE DATABASE bankDatabase;

USE bankDatabase;

CREATE TABLE customers (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	phone VARCHAR(11) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE accounts(
	id INT NOT NULL AUTO_INCREMENT,
	customer_id INT NOT NULL,
	balance INT NOT NULL,
    pass INT NOT NULL CHECK (pass BETWEEN 6 AND 10),
	PRIMARY KEY (id),
	FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO customers (first_name, last_name, email, phone) VALUES
	('James', 'Albright', 'james@atu.ie', '0831234567'),
	('Bob', 'Dylan', 'Bob@atu.ie', '0831235678'),
	('Kevin', 'Donnell', 'kevin@atu.ie', '0851234567');
	
INSERT INTO accounts (customer_id, pass, balance) VALUES
	(1, 123456, 1200),
	(2, 654321, 300),
	(3, 123456789, 25);
	
COMMIT;