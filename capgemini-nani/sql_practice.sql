SQL Practice 
=============
create database practice_sql;


--CREATING TABLES FOR PRACTICE
--============================

-- Create a table for storing customers
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15)
);

-- Create a table for storing addresses
CREATE TABLE addresses (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    street VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    postal_code VARCHAR(20),
    country VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


-- Create a table for storing orders
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Create a table for storing order items
CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_name VARCHAR(100),
    quantity INT,
    unit_price DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);



--INSERTING DATA INTO TABLES TO PRACTICE
--=======================================

-- Insert data into the customers table
INSERT INTO customers (first_name, last_name, email, phone_number)
VALUES
    ('Ramesh', 'Kumar', 'ramesh@example.com', '9876543210'),
    ('Suresh', 'Sharma', 'suresh@example.com', '8765432109'),
    ('Preeti', 'Patel', 'preeti@example.com', '7654321098'),
    ('Vikram', 'Singh', 'vikram@example.com', '6543210987'),
    ('Priya', 'Mishra', 'priya@example.com', '5432109876'),
    ('Amit', 'Verma', 'amit@example.com', '4321098765'),
    ('Anita', 'Reddy', 'anita@example.com', '3210987654'),
    ('Rajesh', 'Gupta', 'rajesh@example.com', '2109876543'),
    ('Deepak', 'Shah', 'deepak@example.com', '1098765432'),
    ('Neha', 'Jain', 'neha@example.com', '0987654321');


-- Insert data into the addresses table
INSERT INTO addresses (customer_id, street, city, state, postal_code, country)
VALUES
    (1, '123 ABC Street', 'Mumbai', 'Maharashtra', '400001', 'India'),
    (2, '456 XYZ Street', 'Delhi', 'Delhi', '110001', 'India'),
    (3, '789 PQR Street', 'Bangalore', 'Karnataka', '560001', 'India'),
    (4, '101 QWE Street', 'Kolkata', 'West Bengal', '700001', 'India'),
    (5, '888 JKL Street', 'Chennai', 'Tamil Nadu', '600001', 'India'),
    (6, '222 MNO Street', 'Hyderabad', 'Telangana', '500001', 'India'),
    (7, '555 UVW Street', 'Pune', 'Maharashtra', '411001', 'India'),
    (8, '999 XYZ Street', 'Ahmedabad', 'Gujarat', '380001', 'India'),
    (9, '777 FGH Street', 'Jaipur', 'Rajasthan', '302001', 'India'),
    (10, '333 IJK Street', 'Lucknow', 'Uttar Pradesh', '226001', 'India');

-- Insert data into the orders table
INSERT INTO orders (customer_id, order_date, total_amount)
VALUES
    (1, '2024-03-15', 500.00),
    (2, '2024-03-16', 750.00),
    (3, '2024-03-17', 1000.00),
    (4, '2024-03-18', 600.00),
    (5, '2024-03-19', 900.00),
    (6, '2024-03-20', 1200.00),
    (7, '2024-03-21', 850.00),
    (8, '2024-03-22', 950.00),
    (9, '2024-03-23', 1100.00),
    (10, '2024-03-24', 700.00);

-- Insert data into the order_items table
INSERT INTO order_items (order_id, product_name, quantity, unit_price)
VALUES
    (1, 'Product A', 2, 100.00),
    (1, 'Product B', 1, 150.00),
    (2, 'Product C', 3, 200.00),
    (3, 'Product D', 1, 500.00),
    (4, 'Product E', 2, 200.00),
    (4, 'Product F', 1, 400.00),
    (5, 'Product G', 3, 300.00),
    (5, 'Product H', 1, 600.00),
    (6, 'Product I', 2, 250.00),
    (6, 'Product J', 1, 450.00),
    (7, 'Product K', 4, 100.00),
    (8, 'Product L', 2, 475.00),
    (9, 'Product M', 1, 800.00),
    (9, 'Product N', 3, 350.00),
    (10, 'Product O', 2, 150.00),
    (10, 'Product P', 1, 700.00);




---PRACTICE START
--================