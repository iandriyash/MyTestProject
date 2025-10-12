package homeworks.homework17.repository;

import homeworks.homework17.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты CarRepositoryFileImpl")
class CarRepositoryFileImplTest {

    private CarRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CarRepositoryFileImpl("test-cars.txt");
    }

    @Test
    @DisplayName("Загрузка автомобилей из файла")
    void testFindAll() {
        List<Car> cars = repository.findAll();

        assertNotNull(cars);
        assertEquals(3, cars.size());

        System.out.println("✓ Загружено: " + cars.size() + " автомобилей");
    }

    @Test
    @DisplayName("Подсчёт количества автомобилей")
    void testCount() {
        assertEquals(3, repository.count());
        System.out.println("✓ Count работает");
    }

    @Test
    @DisplayName("Поиск автомобиля по индексу")
    void testFindById() {
        Car car = repository.findById(0);

        assertNotNull(car);
        assertEquals("TestBrand", car.getBrand());

        System.out.println("✓ FindById работает");
    }

    @Test
    @DisplayName("Несуществующий индекс")
    void testFindByIdInvalid() {
        assertNull(repository.findById(999));
        System.out.println("✓ Несуществующий индекс вернул null");
    }

    @Test
    @DisplayName("Поиск по марке")
    void testFindByBrand() {
        List<Car> hondas = repository.findByBrand("Honda");

        assertEquals(1, hondas.size());
        assertEquals("Civic", hondas.get(0).getModel());

        System.out.println("✓ FindByBrand работает");
    }

    @Test
    @DisplayName("Поиск без учёта регистра")
    void testFindByBrandCaseInsensitive() {
        List<Car> hondas = repository.findByBrand("honda");
        assertEquals(1, hondas.size());

        System.out.println("✓ Поиск без учёта регистра работает");
    }

    @Test
    @DisplayName("Добавление нового автомобиля")
    void testSave() {
        int before = repository.count();

        Car newCar = new Car("Audi", "R8", 2023, 500, 5, 8, 9);
        repository.save(newCar);

        assertEquals(before + 1, repository.count());

        System.out.println("✓ Save работает");
    }

    @Test
    @DisplayName("Интеграционный тест")
    void testIntegration() {
        assertEquals(3, repository.count());

        repository.save(new Car("Tesla", "Model S", 2023, 600, 3, 7, 9));
        assertEquals(4, repository.count());

        List<Car> teslas = repository.findByBrand("Tesla");
        assertEquals(1, teslas.size());

        System.out.println("✓ Интеграционный тест пройден");
    }
}