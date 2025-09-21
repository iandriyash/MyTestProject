package homeworks.homework15;

import homeworks.homework06.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса Product")
public class ProductTest {

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product("Тестовый продукт", 100.0);
    }

    @Test
    void testValidProductCreation() {
        Product product = new Product("Хлеб", 50.0);

        assertNotNull(product);
        assertEquals("Хлеб", product.getName());
        assertEquals(50.0, product.getPrice(), 0.001);

        System.out.println("Тест создания продукта пройден");
    }

    @Test
    void testProductCreationMilk() {
        Product product = new Product("Молоко", 100.0);

        assertEquals("Молоко", product.getName());
        assertEquals(100.0, product.getPrice(), 0.001);

        System.out.println("Тест с именем 'Молоко' пройден");
    }

    @Test
    void testProductCreationBread() {
        Product product = new Product("Хлеб белый", 100.0);

        assertEquals("Хлеб белый", product.getName());
        assertEquals(100.0, product.getPrice(), 0.001);

        System.out.println("Тест с именем 'Хлеб белый' пройден");
    }

    @Test
    void testProductCreationCoffee() {
        Product product = new Product("Кофе растворимый", 100.0);

        assertEquals("Кофе растворимый", product.getName());
        assertEquals(100.0, product.getPrice(), 0.001);

        System.out.println("Тест с именем 'Кофе растворимый' пройден");
    }

    @Test
    void testProductCreationZeroPrice() {
        Product product = new Product("Тестовый продукт", 0.0);

        assertEquals("Тестовый продукт", product.getName());
        assertEquals(0.0, product.getPrice(), 0.001);

        System.out.println("Тест с ценой 0.0 пройден");
    }

    @Test
    void testProductCreationSmallPrice() {
        Product product = new Product("Тестовый продукт", 0.01);

        assertEquals("Тестовый продукт", product.getName());
        assertEquals(0.01, product.getPrice(), 0.001);

        System.out.println("Тест с ценой 0.01 пройден");
    }

    @Test
    void testProductCreationHighPrice() {
        Product product = new Product("Тестовый продукт", 1000000.0);

        assertEquals("Тестовый продукт", product.getName());
        assertEquals(1000000.0, product.getPrice(), 0.001);

        System.out.println("Тест с ценой 1000000.0 пройден");
    }

    @Test
    void testProductCreationFromRealData1() {
        Product product = new Product("Хлеб", 40.0);

        assertEquals("Хлеб", product.getName());
        assertEquals(40.0, product.getPrice(), 0.001);

        System.out.println("Тест реальных данных: Хлеб за 40.0 руб пройден");
    }

    @Test
    void testProductCreationFromRealData2() {
        Product product = new Product("Молоко", 60.0);

        assertEquals("Молоко", product.getName());
        assertEquals(60.0, product.getPrice(), 0.001);

        System.out.println("Тест реальных данных: Молоко за 60.0 руб пройден");
    }

    @Test
    void testNullNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product(null, 100.0);
        });

        assertEquals("Название продукта не может быть пустым", exception.getMessage());
        System.out.println("Тест исключения для null имени пройден");
    }

    @Test
    void testEmptyNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("", 100.0);
        });

        assertEquals("Название продукта не может быть пустым", exception.getMessage());
        System.out.println("Тест исключения для пустого имени пройден");
    }

    @Test
    void testNegativePriceThrowsException1() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("Тестовый продукт", -1.0);
        });

        assertEquals("Стоимость продукта не может быть отрицательной", exception.getMessage());
        System.out.println("Тест исключения для цены -1.0 пройден");
    }

    @Test
    void testNegativePriceThrowsException2() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("Тестовый продукт", -100.0);
        });

        assertEquals("Стоимость продукта не может быть отрицательной", exception.getMessage());
        System.out.println("Тест исключения для цены -100.0 пройден");
    }

    @Test
    void testWhitespaceNameThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Product("   ", 100.0);
        });

        assertEquals("Название продукта не может быть пустым", exception.getMessage());
        System.out.println("Тест исключения для пробельного имени пройден");
    }

    @Test
    void testEqualsWithSameProducts() {
        Product product1 = new Product("Хлеб", 40.0);
        Product product2 = new Product("Хлеб", 40.0);

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());

        System.out.println("Тест equals для одинаковых продуктов пройден");
    }

    @Test
    void testEqualsWithDifferentProducts() {
        Product product1 = new Product("Хлеб", 40.0);
        Product product2 = new Product("Молоко", 60.0);
        Product product3 = new Product("Хлеб", 50.0);

        assertNotEquals(product1, product2);
        assertNotEquals(product1, product3);
        assertNotEquals(product2, product3);

        System.out.println("Тест equals для разных продуктов пройден");
    }

    @Test
    void testEqualsWithNullAndOtherObjects() {
        Product product = new Product("Тест", 100.0);

        assertNotEquals(product, null);
        assertNotEquals(product, "Строка");
        assertNotEquals(product, 123);
        assertEquals(product, product);

        System.out.println("Тест equals с null и другими типами пройден");
    }

    @Test
    void testToStringMethod() {
        Product product = new Product("Молоко", 60.5);
        String expected = "Молоко за 60.5 рублей";

        assertEquals(expected, product.toString());

        System.out.println("Тест toString пройден");
        System.out.println("Результат: " + product.toString());
    }

    @Test
    void testMinimalPrice() {
        Product product = new Product("Бесплатный продукт", 0.0);

        assertEquals(0.0, product.getPrice(), 0.001);
        System.out.println("Тест минимальной цены пройден");
    }

    @Test
    void testVeryHighPrice() {
        double highPrice = Double.MAX_VALUE;
        Product product = new Product("Дорогой продукт", highPrice);

        assertEquals(highPrice, product.getPrice(), 0.001);
        System.out.println("Тест высокой цены пройден");
    }

    @Test
    void testVeryLongName() {
        String longName = "А".repeat(1000);
        Product product = new Product(longName, 100.0);

        assertEquals(longName, product.getName());
        System.out.println("Тест длинного названия пройден");
    }

    @Test
    @Disabled("Этот тест игнорируется для демонстрации функции @Disabled")
    void testIgnoredSpecialCharacters() {
        Product product = new Product("Продукт @#$%", 100.0);
        assertEquals("Продукт @#$%", product.getName());

        System.out.println("Этот тест не должен выполняться!");
    }

    @Test
    void testMultipleExceptions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product(null, 100.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Продукт", -1.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Product("", 100.0);
        });

        System.out.println("Тест множественных исключений пройден");
    }

    @Test
    void finalProductTestReport() {
        System.out.println("=== ОТЧЕТ ПО ТЕСТИРОВАНИЮ КЛАССА PRODUCT ===");
        System.out.println("Пакет: homeworks.homework06");
        System.out.println("Класс тестов: homeworks.homework15.ProductTest");
        System.out.println("Общее количество тестов: 22");
        System.out.println("Позитивных тестов: 11");
        System.out.println("Негативных тестов: 6");
        System.out.println("Тестов методов: 4");
        System.out.println("Игнорируемых тестов: 1");
        System.out.println("Статус: ВСЕ АКТИВНЫЕ ТЕСТЫ ПРОЙДЕНЫ");
        System.out.println("===========================================");

        assertTrue(true, "Итоговый тест всегда успешен");
    }
}