package homeworks.homework02;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите 1-е целое число: ");
        int first = scanner.nextInt();

        System.out.print("Введите второе целое число: ");
        int second = scanner.nextInt();

        int sum = first + second;                // Сумма
        int difference = first - second;         // Разница
        int product = first * second;            // Произведение
        double average = (first + second) / 2.0; // Используем 2.0 для дробного результата
        int distance = Math.abs(first - second); // Абсолютная разница (всегда положительная)
        int max = Math.max(first, second);       // Максимум
        int min = Math.min(first, second);       // Минимум

        System.out.println("Сумма двух целых чисел: " + sum);
        System.out.println("Разница двух целых чисел: " + difference);
        System.out.println("Произведение из двух целых чисел: " + product);
        System.out.printf("Среднее из двух целых чисел: %.2f%n", average);
        System.out.println("Расстояние двух целых чисел: " + distance);
        System.out.println("Максимальное целое число: " + max);
        System.out.println("Минимальное целое число: " + min);
    }
}