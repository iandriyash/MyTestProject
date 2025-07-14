package homeworks.homework04; // Определяю пространство имен пакета для организации кода

import java.util.Scanner; // Импортирую класс Scanner для обработки ввода с консоли

public class Task1 { // Объявляю публичный класс Task1 как контейнер для логики программы
    public static void main(String[] args) { // Определяю статический метод main как точку входа приложения
        // Инициализирую объект Scanner для потокового ввода данных с System.in
        Scanner scanner = new Scanner(System.in);

        // Присваиваю переменной input первый символ строки, считанной методом nextLine()
        char input = scanner.nextLine().charAt(0);

        // Присваиваю переменной string заданную последовательность клавиатуры
        String string = "qwertyuiopasdfghjklzxcvbnm";

        // Проверяю условие, является ли input первым символом строки с использованием indexOf
        if (string.indexOf(input) == 0) {
            // Выполняю вывод последнего символа строки, если input - первый
            System.out.println(string.charAt(string.length() - 1));
        }
        else {
            // Присваиваю переменной index позицию символа input в строке
            int index = string.indexOf(input);
            // Выполняю вывод символа, находящегося слева от input с учетом циклической структуры
            System.out.println(string.charAt((index - 1 + string.length()) % string.length()));
        }
    }
}