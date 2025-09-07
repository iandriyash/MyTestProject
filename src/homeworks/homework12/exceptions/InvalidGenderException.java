package homeworks.homework12.exceptions;

/**
 * Исключение для неверного формата пола
 */
public class InvalidGenderException extends InvalidDataException {
    public InvalidGenderException(String genderValue) {
        super("Неверный формат пола: " + genderValue + ". Ожидается 'f' или 'm'");
    }
}