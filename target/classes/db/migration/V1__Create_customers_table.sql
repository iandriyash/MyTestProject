-- V1: Создание таблицы покупателей
CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Добавим тестовых покупателей
INSERT INTO customers (first_name, last_name) VALUES
    ('Иван', 'Иванов'),
    ('Мария', 'Петрова'),
    ('Алексей', 'Сидоров');