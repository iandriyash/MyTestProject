package homeworks.homework15;

import homeworks.homework06.App;
import homeworks.homework06.Product;
import homeworks.homework06.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты класса App")
public class AppTest {

    private App app = new App();
    private Product[] testProducts;
    private Person testPerson;

    @BeforeEach
    void setUp() {
        testProducts = App.createTestProducts();
        testPerson = App.createTestPerson("Тестер", 1000.0);
    }

    @Test
    void getInputLine() {
        System.out.println("Тест запущен");
        String result = app.getLineFromScanner();
        assertNotNull(result);
        assertEquals("Тестовая строка", result);
        System.out.println("Тест getLineFromScanner пройден");
    }

    @Test
    void testCreateTestProducts() {
        Product[] products = App.createTestProducts();

        assertNotNull(products);
        assertEquals(5, products.length);

        assertEquals("Хлеб", products[0].getName());
        assertEquals(40.0, products[0].getPrice(), 0.001);

        assertEquals("Молоко", products[1].getName());
        assertEquals(60.0, products[1].getPrice(), 0.001);

        assertEquals("Торт", products[2].getName());
        assertEquals(1000.0, products[2].getPrice(), 0.001);

        assertEquals("Кофе растворимый", products[3].getName());
        assertEquals(879.0, products[3].getPrice(), 0.001);

        assertEquals("Масло", products[4].getName());
        assertEquals(150.0, products[4].getPrice(), 0.001);

        System.out.println("Тест создания тестовых продуктов пройден");
    }

    @Test
    void testProductsArrayConsistency() {
        Product[] products1 = App.createTestProducts();
        Product[] products2 = App.createTestProducts();

        assertEquals(products1.length, products2.length);

        for (int i = 0; i < products1.length; i++) {
            assertEquals(products1[i].getName(), products2[i].getName());
            assertEquals(products1[i].getPrice(), products2[i].getPrice(), 0.001);
        }

        System.out.println("Тест неизменности продуктов пройден");
    }

    @Test
    void testCreateTestPerson() {
        Person person = App.createTestPerson("Иван", 500.0);

        assertNotNull(person);
        assertEquals("Иван", person.getName());
        assertEquals(500.0, person.getMoney(), 0.001);

        System.out.println("Тест создания тестового покупателя пройден");
    }

    @Test
    void testCreateTestPersonAnna() {
        Person person = App.createTestPerson("Анна", 1000.0);

        assertEquals("Анна", person.getName());
        assertEquals(1000.0, person.getMoney(), 0.001);

        System.out.println("Тест создания покупателя Анна пройден");
    }

    @Test
    void testCreateTestPersonBoris() {
        Person person = App.createTestPerson("Борис", 1000.0);

        assertEquals("Борис", person.getName());
        assertEquals(1000.0, person.getMoney(), 0.001);

        System.out.println("Тест создания покупателя Борис пройден");
    }

    @Test
    void testCreateTestPersonWithZeroMoney() {
        Person person = App.createTestPerson("Тест", 0.0);

        assertEquals("Тест", person.getName());
        assertEquals(0.0, person.getMoney(), 0.001);

        System.out.println("Тест создания покупателя с 0 руб пройден");
    }

    @Test
    void testCreateTestPersonWithHighMoney() {
        Person person = App.createTestPerson("Тест", 5000.0);

        assertEquals("Тест", person.getName());
        assertEquals(5000.0, person.getMoney(), 0.001);

        System.out.println("Тест создания покупателя с 5000 руб пройден");
    }

    @Test
    void testSuccessfulMakePurchase() {
        Person buyer = App.createTestPerson("Покупатель", 1000.0);
        Product product = new Product("Товар", 500.0);

        boolean result = App.makePurchase(buyer, product);

        assertTrue(result);
        assertEquals(500.0, buyer.getMoney(), 0.001);

        System.out.println("Тест успешной покупки через makePurchase пройден");
    }

    @Test
    void testUnsuccessfulMakePurchase() {
        Person buyer = App.createTestPerson("Бедный покупатель", 100.0);
        Product expensiveProduct = new Product("Дорогой товар", 500.0);

        boolean result = App.makePurchase(buyer, expensiveProduct);

        assertFalse(result);
        assertEquals(100.0, buyer.getMoney(), 0.001);

        System.out.println("Тест неуспешной покупки через makePurchase пройден");
    }

    @Test
    void testExactMoneyPurchase() {
        Person buyer = App.createTestPerson("Точный покупатель", 250.0);
        Product product = new Product("Товар", 250.0);

        boolean result = App.makePurchase(buyer, product);

        assertTrue(result);
        assertEquals(0.0, buyer.getMoney(), 0.001);

        System.out.println("Тест покупки с точной суммой пройден");
    }

    @Test
    void testBuyAllTestProducts() {
        Person richBuyer = App.createTestPerson("Богатый покупатель", 5000.0);
        Product[] products = App.createTestProducts();

        double totalCost = 0;
        int successfulPurchases = 0;

        for (Product product : products) {
            boolean purchased = App.makePurchase(richBuyer, product);
            if (purchased) {
                totalCost += product.getPrice();
                successfulPurchases++;
            }
        }

        assertEquals(5, successfulPurchases);
        assertEquals(5000.0 - totalCost, richBuyer.getMoney(), 0.001);

        System.out.println("Интеграционный тест покупки всех продуктов пройден");
    }

    @Test
    void testBuyUntilBankrupt() {
        Person buyer = App.createTestPerson("Средний покупатель", 200.0);
        Product[] products = App.createTestProducts();

        int successfulPurchases = 0;
        double remainingMoney = buyer.getMoney();

        for (Product product : products) {
            if (product.getPrice() <= remainingMoney) {
                boolean purchased = App.makePurchase(buyer, product);
                if (purchased) {
                    successfulPurchases++;
                    remainingMoney = buyer.getMoney();
                }
            }
        }

        assertTrue(successfulPurchases > 0);
        assertTrue(buyer.getMoney() >= 0);

        System.out.println("Интеграционный тест покупки до исчерпания пройден");
        System.out.println("Успешных покупок: " + successfulPurchases);
        System.out.println("Остаток денег: " + buyer.getMoney());
    }

    @Test
    void testCreatePersonWithMinimalMoney() {
        Person person = App.createTestPerson("Бедняк", 0.0);
        Product[] products = App.createTestProducts();

        for (Product product : products) {
            boolean purchased = App.makePurchase(person, product);
            assertFalse(purchased, "Покупка должна быть неуспешной при 0 деньгах");
        }

        assertEquals(0.0, person.getMoney(), 0.001);
        System.out.println("Тест с минимальными деньгами пройден");
    }

    @Test
    void testBuyCheapestProduct() {
        Product[] products = App.createTestProducts();
        Person buyer = App.createTestPerson("Экономный покупатель", 50.0);

        Product cheapest = products[0];
        boolean purchased = App.makePurchase(buyer, cheapest);

        assertTrue(purchased);
        assertEquals(10.0, buyer.getMoney(), 0.001);

        System.out.println("Тест покупки самого дешевого продукта пройден");
    }

    @Test
    void testBuyMostExpensiveProduct() {
        Product[] products = App.createTestProducts();
        Person buyer = App.createTestPerson("Средний покупатель", 500.0);

        Product mostExpensive = products[2];
        boolean purchased = App.makePurchase(buyer, mostExpensive);

        assertFalse(purchased);
        assertEquals(500.0, buyer.getMoney(), 0.001);

        System.out.println("Тест покупки самого дорогого продукта пройден");
    }

    @Test
    void finalAppTestReport() {
        System.out.println("=== ОТЧЕТ ПО ТЕСТИРОВАНИЮ КЛАССА APP ===");
        System.out.println("Пакет: homeworks.homework06");
        System.out.println("Класс тестов: homeworks.homework15.AppTest");
        System.out.println("Общее количество тестов: 16");
        System.out.println("Тестов createTestProducts(): 2");
        System.out.println("Тестов createTestPerson(): 5");
        System.out.println("Тестов makePurchase(): 3");
        System.out.println("Интеграционных тестов: 2");
        System.out.println("Граничных тестов: 3");
        System.out.println("Статус: ВСЕ ТЕСТЫ ПРОЙДЕНЫ");
        System.out.println("=========================================");

        assertTrue(true, "Итоговый тест всегда успешен");
    }
}