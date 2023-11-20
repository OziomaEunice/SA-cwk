-- create table for customer
DROP TABLE IF EXISTS customerInfoReport;
CREATE TABLE customerInfoReport (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL
);


-- create table for purchases made by customers
DROP TABLE IF EXISTS customerPurchaseReport;
CREATE TABLE customerPurchaseReport (
    purchaseID INTEGER PRIMARY KEY,
    customerId INTEGER NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customerInfoReport(id) ON DELETE CASCADE,
    purchaseDate DATE NOT NULL,
    purchaseTime TIME NOT NULL,
    purchaseAmount INTEGER NOT NULL
);


-- insert some data
INSERT INTO customerInfoReport (name, email) VALUES ('John Doe', 'johndoe@gmail.com');
INSERT INTO customerInfoReport (name, email) VALUES ('Susan Smith', 'susansmith@gmail.com');
INSERT INTO customerInfoReport (name, email) VALUES ('Anna Bugatti', 'abugatti@gmail.com');


INSERT INTO customerPurchaseReport (purchaseID, customerId, purchaseDate, purchaseTime, purchaseAmount) VALUES (10, 1, '2023-11-01', '12:00:00', 1000);
INSERT INTO customerPurchaseReport (purchaseID, customerId, purchaseDate, purchaseTime, purchaseAmount) VALUES (21, 2, '2023-01-01', '07:30:00', 2000);
INSERT INTO customerPurchaseReport (purchaseID, customerId, purchaseDate, purchaseTime, purchaseAmount) VALUES (37, 3, '2022-04-21', '11:45:00', 3000);