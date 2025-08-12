package homeworks.homework10;

import homeworks.homework10.abstractPackage.AbstractClass;
import homeworks.homework10.abstractPackage.SomeClass;
import homeworks.homework10.interfacePackage.SomeInterface;
import homeworks.homework10.interfacePackage.SomeInterfaceClass;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы с абстрактными классами ===");
        AbstractClass someClass = new SomeClass();
        System.out.println("Сумма 10 + 11 = " + someClass.calculateSum(10, 11));
        someClass.displayInfo();

        System.out.println("\n=== Демонстрация работы с интерфейсами ===");
        SomeInterface interfaceObj = new SomeInterfaceClass();
        interfaceObj.performAction();
        interfaceObj.defaultMethod();

        System.out.println("\n=== Демонстрация работы с лямбда выражениями ===");

        // Тестовый массив
        int[] array = {10, 15, 22, 7, 8, 13, 16, 9, 4, 11};
        System.out.println("Исходный массив: " + Arrays.toString(array));

        // 1. Проверка на четность элемента
        System.out.println("\n1. Фильтрация четных элементов:");
        int[] evenNumbers = Sequence.filter(array, (number) -> number % 2 == 0);
        System.out.println("Четные числа: " + Arrays.toString(evenNumbers));

        // 2. Проверка, является ли сумма цифр элемента четным числом
        System.out.println("\n2. Фильтрация элементов с четной суммой цифр:");
        int[] evenDigitSum = Sequence.filter(array, (number) -> {
            int sum = 0;
            int temp = Math.abs(number); // Учитываем отрицательные числа
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return sum % 2 == 0;
        });
        System.out.println("Числа с четной суммой цифр: " + Arrays.toString(evenDigitSum));

        // Дополнительные примеры использования лямбда выражений
        System.out.println("\n=== Дополнительные примеры ===");

        // Числа больше 10
        int[] greaterThan10 = Sequence.filter(array, number -> number > 10);
        System.out.println("Числа больше 10: " + Arrays.toString(greaterThan10));

        // Числа, кратные 3
        int[] divisibleBy3 = Sequence.filter(array, number -> number % 3 == 0);
        System.out.println("Числа, кратные 3: " + Arrays.toString(divisibleBy3));

        // Двузначные числа
        int[] twoDigitNumbers = Sequence.filter(array, number -> number >= 10 && number <= 99);
        System.out.println("Двузначные числа: " + Arrays.toString(twoDigitNumbers));
    }
}
