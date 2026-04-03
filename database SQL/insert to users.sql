-- SAMPLE USERS
INSERT INTO users (full_name, email, password_hash, role)
VALUES
('John Customer', 'john@email.com', 'hashed_pw_123', 'customer'),
('Vendor Mike', 'vendor@email.com', 'hashed_pw_456', 'vendor');

-- SAMPLE RESTAURANTS
INSERT INTO restaurants (vendor_id, name, cuisine, description, delivery_fee, sustainability_score, rating, is_approved)
VALUES
(2, 'Burger House', 'Fast Food', 'Best burgers in town', 4.99, 7, 4.8, TRUE),
(2, 'Pizza Palace', 'Italian', 'Authentic pizza', 3.99, 8, 4.6, TRUE);

-- SAMPLE MENU ITEMS
INSERT INTO menu_items (restaurant_id, item_name, description, price)
VALUES
(1, 'Classic Burger', 'Beef burger with fries', 12.99),
(1, 'Chicken Burger', 'Grilled chicken burger', 11.99),
(2, 'Pepperoni Pizza', '12-inch pizza', 15.99);