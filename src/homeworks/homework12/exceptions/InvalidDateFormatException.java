package homeworks.homework12.exceptions;

/**
 * Исключение для неверного формата даты
 */
public class InvalidDateFormatException extends InvalidDataException {
    public InvalidDateFormatException(String dateValue) {
        super("Неверный формат даты: " + dateValue + ". Ожидается формат dd.mm.yyyy");
    }
}
