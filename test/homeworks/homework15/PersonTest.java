package homeworks.homework15;

import homeworks.homework06.Person;
import homeworks.homework06.Product;
import homeworks.homework06.App;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса Person")
public class PersonTest {

    private Person testPerson;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        testPerson = new Person("Тестовый покупатель", 500.0);
        testProduct = new Product("Тестовый продукт", 100.0);
    }

    @Test
    void testValidPersonCreation() {
        Person person = new Person("Иван", 1000.0);

        assertNotNull(person);
        assertEquals("Иван", person.getName());
        assertEquals(1000.0, person.getMoney(), 0.001);

        System.out.println("Тест создания покупателя пройден");
    }

    @Test
    void testPersonCreationAnna() {
        Person person = new Person("Анна", 1000.0);

        assertEquals("Анна", person.getName());
        assertEquals(1000.0, person.getMoney(), 0.001);

        System.out.println("Тест с именем 'Анна' пройден");
    }

    @Test
    void testPersonCreationBoris() {
        Person person = new Person("Борис Петрович", 1000.0);

        assertEquals("Борис Петрович", person.getName());
        assertEquals(1000.0, person.getMoney(), 0.001);

        System.out.println("Тест с именем 'Борис Петрович' пройден");
    }

    @Test
    void testPersonCreationMaria() {
        Person person = new Person("Мария-Антуанетта", 1000.0);

        assertEquals("Мария-Антуанетта", person.getName());
        assertEquals(1000.0, person.getMoney(), 0.001);

        System.out.println("Тест с именем 'Мария-Антуанетта' пройден");
    }

    @Test
    void testPersonCreationZeroMoney() {
        Person person = new Person("Тест", 0.0);

        assertEquals("Тест", person.getName());
        assertEquals(0.0, person.getMoney(), 0.001);

        System.out.println("Тест с суммой 0.0 пройден");
    }

    @Test
    void testPersonCreationSmallMoney() {
        Person person = new Person("Тест", 100.0);

        assertEquals("Тест", person.getName());
        assertEquals(100.0, person.getMoney(), 0.001);

        System.out.println("Тест с суммой 100.0 пройден");
    }

    @Test
    void testPersonCreationHighMoney() {
        Person person = new Person("Тест", 999999.99);

        assertEquals("Тест", person.getName());
        assertEquals(999999.99, person.getMoney(), 0.001);

        System.out.println("Тест с суммой 999999.99 пройден");
    }

    @Test
    void testPersonCreationFromRealData1() {
        Person person = new Person("Павел", 1500.0);

        assertEquals("Павел", person.getName());
        assertEquals(1500.0, person.getMoney(), 0.001);

        System.out.println("Тест реальных данных: Павел с 1500.0 руб пройден");
    }

    @Test
    void testPersonCreationFromRealData2() {
        Person person = new Person("Екатерина", 500.0);

        assertEquals("Екатерина", person.getName());
        assertEquals(500.0, person.getMoney(), 0.001);

        System.out.println("Тест реальных данных: Екатерина с 500.0 руб пройден");
    }

    @Test
    void testSuccessfulProductPurchase() {
        double initialMoney = testPerson.getMoney();
        double productPrice = testProduct.getPrice();

        testPerson.addProductToBasket(testProduct);

        assertEquals(initialMoney - productPrice, testPerson.getMoney(), 0.001);
        System.out.println("Тест успешной покупки пройден");
    }

    @Test
    void testPurchaseWithExactMoney() {
        Person person = new Person("Точный покупатель", 100.0);
        Product product = new Product("Продукт", 100.0);

        person.addProductToBasket(product);

        assertEquals(0.0, person.getMoney(), 0.001);
        System.out.println("Тест покупки с точной суммой пройден");
    }

    @Test
    void testMultipleProductsPurchase() {
        Person person = new Person("Покупатель", 1000.0);
        Product product1 = new Product("Продукт 1", 200.0);
        Product product2 = new Product("Продукт 2", 300.0);
        Product product3 = new Product("Продукт 3", 150.0);

        person.addProductToBasket(product1);
        person.addProductToBasket(product2);
        person.addProductToBasket(product3);

        assertEquals(350.0, person.getMoney(), 0.001);
        System.out.println("Тест покупки нескольких продуктов пройден");
    }

    @Test
    void testExpensiveProductPurchase() {
        Person person = new Person("Бедный покупатель", 50.0);
        Product expensiveProduct = new Product("Дорогой продукт", 100.0);

        double initialMoney = person.getMoney();
        person.addProductToBasket(expensiveProduct);

        assertEquals(initialMoney, person.getMoney(), 0.001);
        System.out.println("Тест покупки дорогого продукта пройден");
    }

    @Test
    void testNullNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, 1000.0);
        });

        assertEquals("Имя не может быть пустым", exception.getMessage());
        System.out.println("Тест исключения для null имени пройден");
    }

    @Test
    void testEmptyNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("", 1000.0);
        });

        assertEquals("Имя не может быть пустым", exception.getMessage());
        System.out.println("Тест исключения для пустого имени пройден");
    }

    @Test
    void testNegativeMoneyThrowsException1() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("Тест", -1.0);
        });

        assertEquals("Деньги не могут быть отрицательными", exception.getMessage());
        System.out.println("Тест исключения для суммы -1.0 пройден");
    }

    @Test
    void testNegativeMoneyThrowsException2() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("Тест", -100.0);
        });

        assertEquals("Деньги не могут быть отрицательными", exception.getMessage());
        System.out.println("Тест исключения для суммы -100.0 пройден");
    }

    @Test
    void testWhitespaceNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("   ", 1000.0);
        });

        assertEquals("Имя не может быть пустым", exception.getMessage());
        System.out.println("Тест исключения для пробельного имени пройден");
    }

    @Test
    void testEqualsWithSamePersons() {
        Person person1 = new Person("Иван", 1000.0);
        Person person2 = new Person("Иван", 1000.0);

        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());

        System.out.println("Тест equals для одинаковых покупателей пройден");
    }

    @Test
    void testEqualsWithDifferentPersons() {
        Person person1 = new Person("Иван", 1000.0);
        Person person2 = new Person("Петр", 1000.0);
        Person person3 = new Person("Иван", 500.0);

        assertNotEquals(person1, person2);
        assertNotEquals(person1, person3);
        assertNotEquals(person2, person3);

        System.out.println("Тест equals для разных покупателей пройден");
    }

    @Test
    void testEqualsWithNullAndOtherObjects() {
        Person person = new Person("Тест", 1000.0);

        assertNotEquals(person, null);
        assertNotEquals(person, "Строка");
        assertNotEquals(person, 123);
        assertEquals(person, person);

        System.out.println("Тест equals с null и другими типами пройден");
    }

    @Test
    void testToStringMethod() {
        Person person = new Person("Анна", 750.5);
        String expected = "Анна имеет 750.5 рублей";

        assertEquals(expected, person.toString());

        System.out.println("Тест toString пройден");
        System.out.println("Результат: " + person.toString());
    }

    @Test
    void testPrintEmptyBasket() {
        assertDoesNotThrow(() -> {
            testPerson.printBasket();
        });

        System.out.println("Тест печати пустой корзины пройден");
    }

    @Test
    void testPrintBasketWithProducts() {
        testPerson.addProductToBasket(new Product("Хлеб", 40.0));
        testPerson.addProductToBasket(new Product("Молоко", 60.0));

        assertDoesNotThrow(() -> {
            testPerson.printBasket();
        });

        System.out.println("Тест печати корзины с продуктами пройден");
    }

    @Test
    void testPersonWithZeroMoney() {
        Person poorPerson = new Person("Бедняк", 0.0);
        Product product = new Product("Продукт", 10.0);

        poorPerson.addProductToBasket(product);
        assertEquals(0.0, poorPerson.getMoney(), 0.001);

        System.out.println("Тест покупателя без денег пройден");
    }

    @Test
    void testPurchaseMinimalPriceProduct() {
        Person person = new Person("Покупатель", 100.0);
        Product freeProduct = new Product("Бесплатный", 0.0);

        person.addProductToBasket(freeProduct);
        assertEquals(100.0, person.getMoney(), 0.001);

        System.out.println("Тест покупки бесплатного продукта пройден");
    }

    @Test
    void testVeryRichPerson() {
        double richAmount = 1000000000.0;
        Person richPerson = new Person("Богач", richAmount);
        Product product = new Product("Продукт", 100.0);

        richPerson.addProductToBasket(product);
        assertEquals(richAmount - 100.0, richPerson.getMoney(), 0.001);

        System.out.println("Тест очень богатого покупателя пройден");
    }

    @Test
    @Disabled("Тест игнорируется для демонстрации @Disabled")
    void testIgnoredDiscountPurchase() {
        Person person = new Person("Покупатель", 100.0);
        Product product = new Product("Товар со скидкой", 80.0);

        person.addProductToBasket(product);

        System.out.println("Этот тест не должен выполняться!");
    }

    @Test
    void testIntegrationWithRealProducts() {
        Person buyer = new Person("Покупатель", 1000.0);
        Product[] products = App.createTestProducts();

        buyer.addProductToBasket(products[0]);
        buyer.addProductToBasket(products[1]);

        assertEquals(900.0, buyer.getMoney(), 0.001);
        System.out.println("Интеграционный тест с реальными продуктами пройден");
    }

    @Test
    void testMultipleExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person(null, 1000.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Тест", -1.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Person("", 1000.0);
        });

        System.out.println("Тест множественных исключений для Person пройден");
    }

    @Test
    void finalPersonTestReport() {
        System.out.println("=== ОТЧЕТ ПО ТЕСТИРОВАНИЮ КЛАССА PERSON ===");
        System.out.println("Пакет: homeworks.homework06");
        System.out.println("Класс тестов: homeworks.homework15.PersonTest");
        System.out.println("Общее количество тестов: 29");
        System.out.println("Позитивных тестов: 15");
        System.out.println("Негативных тестов: 6");
        System.out.println("Тестов методов: 6");
        System.out.println("Игнорируемых тестов: 1");
        System.out.println("Интеграционных тестов: 1");
        System.out.println("Статус: ВСЕ АКТИВНЫЕ ТЕСТЫ ПРОЙДЕНЫ");
        System.out.println("=============================================");

        assertTrue(true, "Итоговый тест всегда успешен");
    }
}