# Select all users in this table
SELECT * FROM tealeaf_db.users;
SELECT email FROM users;
# Add new rows to the table
INSERT INTO users(email, password) VALUES ("bay@test.com", "1234");
INSERT INTO users(email, password) VALUES ("elton@test.com", "1234"), ("amber@test.com", "1234"), ("astromajor@test.com", "1234");

SELECT * FROM tealeaf_db.products;
SELECT * FROM products;
SELECT name FROM products;
SELECT price FROM products;
SELECT name, price FROM products;
INSERT INTO products (name, price) VALUES ("BayTea", 5.0), ("AmbTea", 5.0);

SELECT * FROM orders;
JOIN on CARTS