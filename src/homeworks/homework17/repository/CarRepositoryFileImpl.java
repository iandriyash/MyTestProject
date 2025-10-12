package homeworks.homework17.repository;

import homeworks.homework17.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepositoryFileImpl implements CarRepository {
    private final String filePath;
    private List<Car> cars;

    public CarRepositoryFileImpl(String filePath) {
        this.filePath = filePath;
        this.cars = new ArrayList<>();
        loadCarsFromFile();
    }

    /**
     * Загрузка автомобилей из файла
     * Формат: brand,model,year,power,acceleration,suspension,durability
     */
    private void loadCarsFromFile() {
        try {
            // Попытка загрузить из resources
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if (inputStream != null) {
                // Файл найден в resources
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                parseCars(reader);
            } else {
                // Файл не в resources, пробуем прямой путь
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                parseCars(reader);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private void parseCars(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Пропускаем пустые строки и комментарии
            if (line.trim().isEmpty() || line.startsWith("#")) {
                continue;
            }

            try {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    Car car = new Car(
                            parts[0].trim(),                    // brand
                            parts[1].trim(),                    // model
                            Integer.parseInt(parts[2].trim()),  // year
                            Integer.parseInt(parts[3].trim()),  // power
                            Integer.parseInt(parts[4].trim()),  // acceleration
                            Integer.parseInt(parts[5].trim()),  // suspension
                            Integer.parseInt(parts[6].trim())   // durability
                    );
                    cars.add(car);
                }
            } catch (NumberFormatException e) {
                System.err.println("Ошибка формата данных в строке: " + line);
            }
        }
        reader.close();
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }

    @Override
    public Car findById(int index) {
        if (index >= 0 && index < cars.size()) {
            return cars.get(index);
        }
        return null;
    }

    @Override
    public List<Car> findByBrand(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public int count() {
        return cars.size();
    }
}