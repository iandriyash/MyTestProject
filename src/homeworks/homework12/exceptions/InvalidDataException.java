package homeworks.homework12.exceptions;

/**
 * Исключение для некорректных данных
 */
public class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
