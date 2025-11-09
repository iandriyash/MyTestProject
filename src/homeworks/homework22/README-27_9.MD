# Домашнее задание 27.9 — Spring Boot, Swagger, Docker

Приложение реализует REST API для каталога телевизоров с использованием Spring Boot, PostgreSQL и Swagger UI. Документация формируется автоматически, тестирование выполняется через Postman.

## Основные технологии
Java 21, Spring Boot 3.2, Spring Web, Spring Data JPA, PostgreSQL, Swagger UI, Actuator, Docker, Maven.

## Основные эндпоинты
GET /api/tvs – список  
POST /api/tvs – добавление  
PUT /api/tvs/{id} – обновление  
DELETE /api/tvs/{id} – удаление  
Swagger UI: http://localhost:8080/swagger-ui/index.html

## Запуск
```bash
docker compose up --build
