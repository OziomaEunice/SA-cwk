-- create table for price control
DROP TABLE IF EXISTS typeOfProduct;

CREATE TABLE typeOfProduct (
    ProductID INTEGER PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    Price decimal(10,2)
);


-- create table for sales offer
DROP TABLE IF EXISTS salesoffer;

CREATE TABLE salesOffer (
    salesOfferID INTEGER PRIMARY KEY,
    salesOfferName VARCHAR(255),
    Description VARCHAR(255)
);


-- create table for products sales offer
DROP TABLE IF EXISTS productSalesOffer;

CREATE TABLE productSalesOffer (
    ProductID INTEGER,
    salesOfferID INTEGER,
    FOREIGN KEY (ProductID) REFERENCES typeOfProduct(ProductID) ON DELETE CASCADE,
    FOREIGN KEY (salesOfferID) REFERENCES salesOffer(salesOfferID) ON DELETE CASCADE,
    PRIMARY KEY (ProductID, salesOfferID)
);


-- Insert some data sample into the database
INSERT INTO typeOfProduct (ProductID, ProductName, Price) VALUES (1, 'Coca Cola', 1.50);
INSERT INTO typeOfProduct (ProductID, ProductName, Price) VALUES (2, 'Fanta', 1.99);
INSERT INTO typeOfProduct (ProductID, ProductName, Price) VALUES (3, 'Sprite', 2.00);


INSERT INTO salesOffer (salesOfferID, salesOfferName, Description) VALUES (1, 'Buy 3 Get 1 Free', 'Buy 3 products of the same type and have 1 for free');
INSERT INTO salesOffer (salesOfferID, salesOfferName, Description) VALUES (2, 'Free delivery', 'Buy items and get free delivery');
INSERT INTO salesOffer (salesOfferID, salesOfferName, Description) VALUES (3, 'Buy 2 Get 1 Free', 'Buy 2 products of the same type and have 1 for free');
INSERT INTO salesOffer (salesOfferID, salesOfferName, Description) VALUES (4, 'Buy 4 Get 1 Free', 'Buy 4 products of the different types and have 1 for free');


INSERT INTO productSalesOffer (ProductID, salesOfferID) VALUES (1, 1); -- product coca-cola: buy 3 get 1 free
INSERT INTO productSalesOffer (ProductID, salesOfferID) VALUES (2, 2); -- product fanta: free delivery
INSERT INTO productSalesOffer (ProductID, salesOfferID) VALUES (2, 3); -- product fanta: buy 2 get 1 free
INSERT INTO productSalesOffer (ProductID, salesOfferID) VALUES (3, 4); -- product sprite: buy 4 get 1 free