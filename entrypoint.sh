#!/bin/sh
echo "Waiting for PostgreSQL to start..."
sleep 15
echo "Starting application..."
java -jar /app/app.jar --spring.profiles.active=homework21