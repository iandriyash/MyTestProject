-- V2: Создание таблицы заказов
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_orders INTEGER DEFAULT 0,
    discount DECIMAL(5,2) DEFAULT 0.00,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

-- Добавим тестовые заказы
INSERT INTO orders (customer_id, total_orders, discount) VALUES
    (1, 5, 10.00),
    (2, 3, 5.00),
    (1, 8, 15.00);