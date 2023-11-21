INSERT INTO user_profile (email, password, first_name, last_name,phone_number)
VALUES
('john.doe@example.com', 'password', 'John', 'Doe', '123-456-7890'),
('jane.smith@example.com', 'password', 'Jane', 'Smith', '987-654-3210'),
('alice.jones@example.com', 'password', 'Alice', 'Jones', '456-789-0123');


-- Sample INSERT statements for products with catalog name "Electronics"
INSERT INTO products (name, price, image, description, catalog_name, meta_info, quantity_in_stock)
VALUES
    ('Laptop', 1299.99, 'laptop_image.png', 'High-performance laptop', 'Electronics', '{"brand": "ABC"}', 10),
    ('Smartphone', 699.99, 'phone_image.png', 'Flagship smartphone', 'Electronics', '{"brand": "XYZ"}', 15),
    ('Smartwatch', 199.99, 'smartwatch_image.png', 'Fitness tracking smartwatch', 'Electronics', '{"brand": "FitLife"}', 20),
    ('Wireless Earbuds', 129.99, 'earbuds_image.png', 'Noise-canceling wireless earbuds', 'Electronics', '{"brand": "SoundBeats"}', 25),
    ('Gaming PC', 1999.99, 'gaming_pc_image.png', 'High-end gaming PC', 'Electronics', '{"brand": "GamerTech"}', 5);

-- Sample INSERT statements for products with catalog name "Clothing"
INSERT INTO products (name, price, image, description, catalog_name, meta_info, quantity_in_stock)
VALUES
    ('Mens Jacket', 89.99, 'jacket_image.png', 'Waterproof winter jacket', 'Clothing', '{"size": "L", "color": "Black"}', 50),
    ('Womes Sweater', 49.99, 'sweater_image.png', 'Cozy knit sweater', 'Clothing', '{"size": "M", "color": "Red"}', 40),
    ('Mens Jeans', 59.99, 'jeans_image.png', 'Slim-fit denim jeans', 'Clothing', '{"size": "32", "color": "Blue"}', 30),
    ('Womens Dress', 69.99, 'dress_image.png', 'Elegant evening dress', 'Clothing', '{"size": "S", "color": "Black"}', 20),
    ('Running Shoes', 79.99, 'shoes_image.png', 'Comfortable running shoes', 'Clothing', '{"size": "9", "color": "White"}', 35);


INSERT INTO products (name, price, image, description, catalog_name, meta_info, quantity_in_stock)
VALUES
    ('To Kill a Mockingbird', 15.99, 'b1.png', 'A novel Harper Lee', 'Books', '{"author": "Harper Lee"}', 50),
    ('The Great Gatsby', 9.99, 'b2.png', 'A novel by American writer F. Scott Fitzgerald', 'Books', '{"author": "F. Scott Fitzgerald"}', 40);
