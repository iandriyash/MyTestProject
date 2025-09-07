package homeworks.homework14;

import homeworks.homework14.utils.ParseUtils;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Тестирование parseCount и validateCount ===");

        Integer result1 = ParseUtils.parseCount("100");
        System.out.println("parseCount(\"100\"): " + result1);

        Integer result2 = ParseUtils.validateCount("BbUObUB");
        System.out.println("validateCount(\"BbUObUB\"): " + result2);

        System.out.println("\n=== Дополнительные тесты для целых чисел ===");
        Integer result3 = ParseUtils.validateCount("42");
        System.out.println("validateCount(\"42\"): " + result3);
        Integer result4 = ParseUtils.validateCount("-123");
        System.out.println("validateCount(\"-123\"): " + result4);
        Integer result5 = ParseUtils.validateCount("abc123");
        System.out.println("validateCount(\"abc123\"): " + result5);

        System.out.println("\n=== Тестирование исключений ===");
        try {
            Integer result6 = ParseUtils.parseCount("invalid");
            System.out.println("parseCount(\"invalid\"): " + result6);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n=== Тестирование parseNumber и validateNumber ===");
        Double result7 = ParseUtils.parseNumber("3.14");
        System.out.println("parseNumber(\"3.14\"): " + result7);
        Double result8 = ParseUtils.validateNumber("2.5");
        System.out.println("validateNumber(\"2.5\"): " + result8);
        Double result9 = ParseUtils.validateNumber("invalid_double");
        System.out.println("validateNumber(\"invalid_double\"): " + result9);
        Double result10 = ParseUtils.validateNumber("100");
        System.out.println("validateNumber(\"100\"): " + result10);
        Double result11 = ParseUtils.validateNumber("-45.67");
        System.out.println("validateNumber(\"-45.67\"): " + result11);

        System.out.println("\n=== Тестирование исключений для дробных чисел ===");
        try {
            Double result12 = ParseUtils.parseNumber("not_a_number");
            System.out.println("parseNumber(\"not_a_number\"): " + result12);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}