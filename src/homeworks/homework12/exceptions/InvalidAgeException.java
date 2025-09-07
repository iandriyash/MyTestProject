package homeworks.homework12.exceptions;

/**
 * Исключение для неверного формата возраста
 */
public class InvalidAgeException extends InvalidDataException {
    public InvalidAgeException(String ageValue) {
        super("Неверный формат возраста: " + ageValue + ". Ожидается целое положительное число");
    }
}
