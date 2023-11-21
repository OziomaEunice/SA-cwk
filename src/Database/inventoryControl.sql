-- create table for items
CREATE TABLE items (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    category VARCHAR(255),
    price REAL NOT NULL,
    description TEXT NOT NULL,
    supplier VARCHAR(255)
);


-- create table for stock levels
CREATE TABLE stock_levels (
    item_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items(id)
);


-- insert some data
INSERT INTO items (name, category, price, description, supplier) VALUES ('coca-cola', 'drink', 1.50, 'with blueberry fruit', 'NationWide Retail 2');
INSERT INTO items (name, category, price, description, supplier) VALUES ('fanta', 'drink', 1.99, 'with lemon', 'NationWide Retail 3');

INSERT INTO stock_levels (item_id, quantity) VALUES (1, 100); -- coca-cola quantity
INSERT INTO stock_levels (item_id, quantity) VALUES (2, 20); -- fanta quantity