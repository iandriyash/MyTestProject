package homeworks.homework06;

/**
 * Главный класс приложения для системы покупок
 * Домашнее задание 6 - Понятия ООП: инкапсуляция
 * Очищено от интерактивной части для unit-тестирования
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА ПОКУПОК ===");
        System.out.println("Домашнее задание 6 - unit-тесты");
        System.out.println("Ветка: homeworks/homework15");
        System.out.println("Основная логика теперь тестируется через unit-тесты");
        System.out.println("Запустите тесты для проверки функционала!");
    }

    /**
     * Метод для получения строки от пользователя (для тестирования)
     * @return тестовая строка
     */
    public String getLineFromScanner() {
        return "Тестовая строка";
    }

    /**
     * Метод для создания тестовых продуктов
     * @return массив продуктов для тестирования
     */
    public static Product[] createTestProducts() {
        return new Product[]{
                new Product("Хлеб", 40),
                new Product("Молоко", 60),
                new Product("Торт", 1000),
                new Product("Кофе растворимый", 879),
                new Product("Масло", 150)
        };
    }

    /**
     * Метод для создания тестового покупателя
     * @param name имя покупателя
     * @param money сумма денег
     * @return объект Person
     */
    public static Person createTestPerson(String name, double money) {
        return new Person(name, money);
    }

    /**
     * Метод для симуляции покупки
     * @param person покупатель
     * @param product продукт
     * @return true если покупка успешна
     */
    public static boolean makePurchase(Person person, Product product) {
        double moneyBefore = person.getMoney();
        person.addProductToBasket(product);
        return person.getMoney() < moneyBefore;
    }
}
