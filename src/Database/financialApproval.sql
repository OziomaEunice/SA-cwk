-- create table for customer
DROP TABLE IF EXISTS customerInfo;
CREATE TABLE customerInfo (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    phone TEXT NOT NULL,
    address TEXT NOT NULL,
    city TEXT NOT NULL,
    zip TEXT NOT NULL,
    country TEXT NOT NULL
);


-- create table for financial approval
DROP TABLE IF EXISTS financialApproval;
CREATE TABLE financialApproval (
    approvalID INTEGER PRIMARY KEY,
    customerId INTEGER NOT NULL,
    FOREIGN KEY (customerId) REFERENCES customerInfo(id),
    approvalStatus TEXT NOT NULL,
    approvalDate DATE NOT NULL,
    approvalTime TIME NOT NULL,
    approvalAmount INTEGER NOT NULL
);


-- insert some data
INSERT INTO customerInfo (name, email, phone, address, city, zip, country) VALUES ('John Doe', 'johndoe@gmail.com', '0123456789', '10 Colinton Rd', 'Edinburgh', 'EH10 5DT', 'UK');
INSERT INTO customerInfo (name, email, phone, address, city, zip, country) VALUES ('Susan Smith', 'susansmith@gmail.com', '0123789111', '5 Princes St', 'Edinburgh', 'EH1 W2C', 'UK');
INSERT INTO customerInfo (name, email, phone, address, city, zip, country) VALUES ('Anna Bugatti', 'abugatti@gmail.com', '0456123789', '67 Washington Br', 'Aberdeen', 'AB5 WPC', 'UK');


INSERT INTO financialApproval (approvalID, customerId, approvalStatus, approvalDate, approvalTime, approvalAmount) VALUES (10, 1, 'Approved', '2023-11-01', '12:00:00', 1000);
INSERT INTO financialApproval (approvalID, customerId, approvalStatus, approvalDate, approvalTime, approvalAmount) VALUES (21, 2, 'Approved', '2023-01-01', '07:30:00', 2000);
INSERT INTO financialApproval (approvalID, customerId, approvalStatus, approvalDate, approvalTime, approvalAmount) VALUES (37, 3, 'Approved', '2022-04-21', '11:45:00', 3000);