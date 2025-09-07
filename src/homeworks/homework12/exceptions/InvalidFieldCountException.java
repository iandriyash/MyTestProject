package homeworks.homework12.exceptions;

/**
 * Исключение для неверного количества полей
 */
public class InvalidFieldCountException extends InvalidDataException {
    private final int expectedCount;
    private final int actualCount;

    public InvalidFieldCountException(int expectedCount, int actualCount) {
        super(String.format("Неверное количество полей. Ожидается: %d, получено: %d",
                expectedCount, actualCount));
        this.expectedCount = expectedCount;
        this.actualCount = actualCount;
    }

    public int getExpectedCount() {
        return expectedCount;
    }

    public int getActualCount() {
        return actualCount;
    }

    public boolean hasMoreFields() {
        return actualCount > expectedCount;
    }

    public boolean hasLessFields() {
        return actualCount < expectedCount;
    }
}