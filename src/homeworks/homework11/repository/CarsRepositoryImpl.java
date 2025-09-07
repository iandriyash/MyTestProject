package homeworks.homework11.repository;

import homeworks.homework11.model.Car;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private List<Car> cars;

    public CarsRepositoryImpl() {
        this.cars = new ArrayList<>();
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void loadCarsFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            cars.clear();
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    cars.add(Car.fromString(line));
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    @Override
    public void saveCarsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Автомобили в базе:");
            writer.println("Number   Model      Color    Mileage  Cost");
            for (Car car : cars) {
                writer.println(car.toString());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    @Override
    public List<String> getCarNumbersByColorOrMileage(String color, long mileage) {
        return cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color) || car.getMileage() == mileage)
                .map(Car::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public long getUniqueModelsCountInPriceRange(long minPrice, long maxPrice) {
        return cars.stream()
                .filter(car -> car.getCost() >= minPrice && car.getCost() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
    }

    @Override
    public String getColorOfCheapestCar() {
        return cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .map(Car::getColor)
                .orElse("Нет данных");
    }

    @Override
    public double getAverageCostByModel(String model) {
        return cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0.0);
    }
}
