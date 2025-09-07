package homeworks.homework12.exceptions;

/**
 * Исключение для неверного формата номера телефона
 */
public class InvalidPhoneNumberException extends InvalidDataException {
    public InvalidPhoneNumberException(String phoneValue) {
        super("Неверный формат номера телефона: " + phoneValue + ". Ожидается целое положительное число");
    }
}