package homeworks.homework11.test;

import homeworks.homework11.model.Car;
import homeworks.homework11.repository.CarsRepository;
import homeworks.homework11.repository.CarsRepositoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Инициализация репозитория
        CarsRepository carsRepository = new CarsRepositoryImpl();

        // Создание тестовых данных
        createTestDataFile();

        // Загрузка данных из файла
        carsRepository.loadCarsFromFile("src/homeworks/homework011/data/cars.txt");

        // Параметры для поиска
        String colorToFind = "Black";
        long mileageToFind = 0L;
        long minPrice = 700000L;
        long maxPrice = 800000L;
        String modelToFind1 = "Toyota";
        String modelToFind2 = "Volvo";

        // Вывод всех автомобилей
        System.out.println("Автомобили в базе:");
        System.out.println("Number   Model      Color    Mileage  Cost");
        List<Car> allCars = carsRepository.getAllCars();
        for (Car car : allCars) {
            System.out.println(car);
        }

        // 1. Номера автомобилей по цвету или пробегу
        System.out.println("\nНомера автомобилей по цвету или пробегу:");
        List<String> carNumbers = carsRepository.getCarNumbersByColorOrMileage(colorToFind, mileageToFind);
        for (String number : carNumbers) {
            System.out.println(number);
        }

        // 2. Количество уникальных моделей в ценовом диапазоне
        long uniqueModelsCount = carsRepository.getUniqueModelsCountInPriceRange(minPrice, maxPrice);
        System.out.println("\nУникальные автомобили: " + uniqueModelsCount + " шт.");

        // 3. Цвет автомобиля с минимальной стоимостью
        String cheapestCarColor = carsRepository.getColorOfCheapestCar();
        System.out.println("\nЦвет автомобиля с минимальной стоимостью: " + cheapestCarColor);

        // 4. Средняя стоимость моделей
        double avgCostToyota = carsRepository.getAverageCostByModel(modelToFind1);
        double avgCostVolvo = carsRepository.getAverageCostByModel(modelToFind2);

        System.out.printf("\nСредняя стоимость модели %s: %.2f%n", modelToFind1, avgCostToyota);
        System.out.printf("Средняя стоимость модели %s: %.2f%n", modelToFind2, avgCostVolvo);

        // Сохранение результатов в файл
        carsRepository.saveCarsToFile("src/homeworks/homework011/data/output.txt");
        saveResultsToFile(carNumbers, uniqueModelsCount, cheapestCarColor, avgCostToyota, avgCostVolvo);
    }

    private static void createTestDataFile() {
        try {
            // Создание директории data если её нет
            Files.createDirectories(Paths.get("src/homeworks/homework011/data"));

            // Создание файла с тестовыми данными
            try (PrintWriter writer = new PrintWriter("src/homeworks/homework011/data/cars.txt")) {
                writer.println("a123me|Mercedes|White|0|8300000");
                writer.println("b873of|Volga|Black|0|673000");
                writer.println("w487mn|Lexus|Grey|76000|900000");
                writer.println("p987hj|Volga|Red|610|704340");
                writer.println("c987ss|Toyota|White|254000|761000");
                writer.println("o983op|Toyota|Black|698000|740000");
                writer.println("p146op|BMW|White|271000|850000");
                writer.println("u893ii|Toyota|Purple|210900|440000");
                writer.println("l097df|Toyota|Black|108000|780000");
                writer.println("y876wd|Toyota|Black|160000|1000000");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при создании тестовых данных: " + e.getMessage());
        }
    }

    private static void saveResultsToFile(List<String> carNumbers, long uniqueCount,
                                          String cheapestColor, double avgToyota, double avgVolvo) {
        try (PrintWriter writer = new PrintWriter("src/homeworks/homework011/data/results.txt")) {
            writer.println("=== РЕЗУЛЬТАТЫ АНАЛИЗА АВТОМОБИЛЕЙ ===");
            writer.println();

            writer.println("Номера автомобилей по цвету Black или пробегу 0:");
            for (String number : carNumbers) {
                writer.println(number);
            }
            writer.println();

            writer.println("Уникальные модели в диапазоне 700-800 тыс.: " + uniqueCount + " шт.");
            writer.println();

            writer.println("Цвет самого дешевого автомобиля: " + cheapestColor);
            writer.println();

            writer.printf("Средняя стоимость Toyota: %.2f%n", avgToyota);
            writer.printf("Средняя стоимость Volvo: %.2f%n", avgVolvo);

        } catch (IOException e) {
            System.err.println("Ошибка при сохранении результатов: " + e.getMessage());
        }
    }
}

