CREATE DATABASE demo_security_jwt;

-- Chạy sau khi run source code
INSERT INTO role (name, create_at, update_at, is_deleted)
VALUES ('ROLE_ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       ('ROLE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);

INSERT INTO users (email, name, password, role_id, create_at, update_at, is_deleted)
VALUES ('admin@gmail.com',
        'admin',
        '$2a$10$wR9UOtBbqVnL3asP4x4MDOahPLLvXqP9GFUXwiVF4aITXgxKGLVAG',
        (SELECT id FROM role WHERE name = 'ROLE_ADMIN'),
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        0);

INSERT INTO category (name, create_at, update_at, is_deleted)
VALUES ('Samsung', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0),
       ('Iphone', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);

-- 10 sản phẩm fake
INSERT INTO product (create_at, is_deleted, update_at, description, name, price, category_id)
VALUES (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Iphone 12', 15000000,
        (SELECT id FROM category WHERE name = 'Iphone')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Iphone 13', 20000000,
        (SELECT id FROM category WHERE name = 'Iphone')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Iphone 14', 25000000,
        (SELECT id FROM category WHERE name = 'Iphone')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Iphone 15', 30000000,
        (SELECT id FROM category WHERE name = 'Iphone')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Samsung Galaxy S22', 22000000,
        (SELECT id FROM category WHERE name = 'Samsung')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Samsung Galaxy S23', 26000000,
        (SELECT id FROM category WHERE name = 'Samsung')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Samsung Galaxy S24', 30000000,
        (SELECT id FROM category WHERE name = 'Samsung')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Samsung A54', 9000000,
        (SELECT id FROM category WHERE name = 'Samsung')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Samsung A34', 7000000,
        (SELECT id FROM category WHERE name = 'Samsung')),
       (CURRENT_TIMESTAMP, 0, CURRENT_TIMESTAMP, 'Fake product', 'Iphone SE 2022', 12000000,
        (SELECT id FROM category WHERE name = 'Iphone'));
