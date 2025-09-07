package homeworks.homework14.utils;

/**
 * Утилитарный класс для парсинга и валидации числовых значений из строк
 */
public class ParseUtils {

    /**
     * Парсит строковое значение в Integer
     * @param value строковое значение для парсинга
     * @return распарсенное целое число
     * @throws IllegalArgumentException если значение невалидно
     */
    public static Integer parseCount(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    /**
     * Валидирует и парсит строковое значение в Integer с обработкой исключений
     * @param value строковое значение для парсинга
     * @return распарсенное целое число или null в случае ошибки
     */
    public static Integer validateCount(String value) {
        try {
            return parseCount(value);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при парсинге целого числа: " + e.getMessage());
            return null;
        }
    }

    /**
     * Парсит строковое значение в Double
     * @param value строковое значение для парсинга
     * @return распарсенное число с плавающей точкой
     * @throws IllegalArgumentException если значение невалидно
     */
    public static Double parseNumber(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    /**
     * Валидирует и парсит строковое значение в Double с обработкой исключений
     * @param value строковое значение для парсинга
     * @return распарсенное число с плавающей точкой или null в случае ошибки
     */
    public static Double validateNumber(String value) {
        try {
            return parseNumber(value);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при парсинге числа с плавающей точкой: " + e.getMessage());
            return null;
        }
    }
}