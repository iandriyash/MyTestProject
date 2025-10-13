package homeworks.homework17.repository;

import homeworks.homework17.Car;
import java.util.List;

public interface CarRepository {
    /**
     * Получить все автомобили из источника данных
     */
    List<Car> findAll();

    /**
     * Получить автомобиль по индексу
     */
    Car findById(int index);

    /**
     * Получить автомобили по марке
     */
    List<Car> findByBrand(String brand);

    /**
     * Сохранить автомобиль
     */
    void save(Car car);

    /**
     * Получить количество автомобилей
     */
    int count();
}