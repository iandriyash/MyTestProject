package homeworks.homework10.interfacePackage;

public interface SomeInterface {
    void performAction();
    default void defaultMethod() {
        System.out.println("Метод по умолчанию в интерфейсе");
    }
}
