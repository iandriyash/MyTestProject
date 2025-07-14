package homeworks.homework04; // Определяю пространство имен пакета для организации кода

import java.util.Scanner; // Импортирую класс Scanner для обработки ввода с консоли
import java.util.regex.Matcher; // Импортирую класс Matcher для выполнения поиска по регулярным выражениям
import java.util.regex.Pattern; // Импортирую класс Pattern для компиляции регулярных выражений

public class Task2 { // Объявляю публичный класс Task2 как контейнер для логики программы
    public static void main(String[] args) { // Определяю статический метод main как точку входа приложения
        // Инициализирую объект Scanner для потокового ввода данных с System.in
        Scanner scanner = new Scanner(System.in);

        // Присваиваю переменной input строку, считанную методом nextLine()
        String input = scanner.nextLine();

        // Компилирую регулярное выражение ">>-->" в объект Pattern для последующего поиска
        Pattern pattern1 = Pattern.compile(">>-->");
        // Создаю экземпляр Matcher для применения паттерна pattern1 к строке input
        Matcher matcher1 = pattern1.matcher(input);

        // Инициализирую целочисленную переменную counter для накопления количества совпадений
        int counter = 0;

        // Выполняю итеративный поиск всех вхождений подстроки ">>-->" с использованием метода find()
        while (matcher1.find()) {
            // Инкрементирую counter при каждом успешном обнаружении совпадения
            counter++;
        }

        // Компилирую регулярное выражение "<--<<" в новый объект Pattern
        Pattern pattern2 = Pattern.compile("<--<<");
        // Создаю новый экземпляр Matcher для применения pattern2 к строке input
        Matcher matcher2 = pattern2.matcher(input);

        // Выполняю итеративный поиск всех вхождений подстроки "<--<<" с использованием метода find()
        while (matcher2.find()) {
            // Инкрементирую counter при каждом успешном обнаружении второго типа совпадения
            counter++;
        }

        // Выполняю вывод значения counter в консоль через метод println
        System.out.println(counter);
    }
}