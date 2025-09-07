package homeworks.homework11.repository;

import homeworks.homework11.model.Car;
import java.util.List;

public interface CarsRepository {
    List<Car> getAllCars();
    void addCar(Car car);
    void loadCarsFromFile(String filename);
    void saveCarsToFile(String filename);
    List<String> getCarNumbersByColorOrMileage(String color, long mileage);
    long getUniqueModelsCountInPriceRange(long minPrice, long maxPrice);
    String getColorOfCheapestCar();
    double getAverageCostByModel(String model);
}

