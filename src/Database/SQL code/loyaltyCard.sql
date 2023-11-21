-- create table for customer information
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    phone TEXT NOT NULL,
    address TEXT NOT NULL,
    city TEXT NOT NULL,
    zip TEXT NOT NULL,
    country TEXT NOT NULL
);


-- create table for loyalty cards
CREATE TABLE loyaltyCard (
    cardID INTEGER PRIMARY KEY AUTO_INCREMENT,
    customerId INTEGER NOT NULL,
    cardNumber TEXT NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customer(id),
    pointsInCard INTEGER default 0,
    pointsUsed INTEGER default 0
);


-- insert some data
INSERT INTO customer (name, email, phone, address, city, zip, country) VALUES ('John Doe', 'johndoe@gmail.com', '0123456789', '10 Colinton Rd', 'Edinburgh', 'EH10 5DT', 'UK');
INSERT INTO customer (name, email, phone, address, city, zip, country) VALUES ('Susan Smith', 'susansmith@gmail.com', '0123789111', '5 Princes St', 'Edinburgh', 'EH1 W2C', 'UK');
INSERT INTO customer (name, email, phone, address, city, zip, country) VALUES ('Anna Bugatti', 'abugatti@gmail.com', '0456123789', '67 Washington Br', 'Aberdeen', 'AB5 WPC', 'UK');

INSERT INTO loyaltyCard (customerId, cardNumber, pointsInCard, pointsUsed) VALUES (1, '123456', 2000, 150);
INSERT INTO loyaltyCard (customerId, cardNumber, pointsInCard, pointsUsed) VALUES (2, '234567', 1000, 0);
INSERT INTO loyaltyCard (customerId, cardNumber, pointsInCard, pointsUsed) VALUES (3, '345678', 500, 500);