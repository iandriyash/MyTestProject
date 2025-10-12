package homeworks.homework17;

import homeworks.homework17.repository.CarRepository;
import homeworks.homework17.repository.CarRepositoryFileImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Тестирование системы гонок с Repository ===\n");

        // Создание репозитория для работы с автомобилями из файла
        CarRepository carRepository = new CarRepositoryFileImpl("cars.txt");

        System.out.println("Загружено автомобилей из файла: " + carRepository.count());
        System.out.println();

        // Вывод всех автомобилей
        System.out.println("Все автомобили из файла:");
        List<Car> allCars = carRepository.findAll();
        for (int i = 0; i < allCars.size(); i++) {
            System.out.println(i + ". " + allCars.get(i));
        }
        System.out.println();

        // Поиск по марке
        System.out.println("Поиск автомобилей марки Ferrari:");
        List<Car> ferraris = carRepository.findByBrand("Ferrari");
        ferraris.forEach(System.out::println);
        System.out.println();

        // Получение автомобиля по индексу
        System.out.println("Автомобиль с индексом 0:");
        Car firstCar = carRepository.findById(0);
        System.out.println(firstCar);
        System.out.println();

        // Создание дополнительных автомобилей вручную
        PerformanceCar performanceCar = new PerformanceCar(
                "McLaren", "P1", 2023, 500, 4, 7, 8,
                new String[]{"Турбо", "Спойлер", "Нитро"}
        );

        ShowCar showCar = new ShowCar(
                "Bugatti", "Veyron", 2023, 800, 3, 6, 9, 5
        );

        // Добавление новых автомобилей в репозиторий
        carRepository.save(performanceCar);
        carRepository.save(showCar);

        System.out.println("Добавлены новые автомобили. Всего в репозитории: " + carRepository.count());
        System.out.println();

        // Создание гаража с автомобилями из репозитория
        Car[] carsArray = allCars.toArray(new Car[0]);
        Garage garage = new Garage(carsArray);

        System.out.println("Создан гараж с автомобилями:");
        System.out.println(garage);
        System.out.println();

        // Создание гонок
        Car[] raceParticipants = {performanceCar, showCar, firstCar};

        CasualRace casualRace = new CasualRace(1000, "Городская трасса", 50000, raceParticipants);
        DragRace dragRace = new DragRace(400, "Прямая дорога", 100000, raceParticipants);
        DriftRace driftRace = new DriftRace(800, "Горная дорога", 75000, raceParticipants);

        System.out.println("Созданные гонки:");
        System.out.println(casualRace);
        System.out.println(dragRace);
        System.out.println(driftRace);
        System.out.println();

        // Демонстрация Lombok - equals и hashCode
        System.out.println("Тестирование Lombok (equals и hashCode):");
        Car car1 = new Car("Audi", "R8", 2022, 500, 5, 8, 9);
        Car car2 = new Car("Audi", "R8", 2022, 500, 5, 8, 9);

        System.out.println("car1.equals(car2): " + car1.equals(car2));
        System.out.println("car1.hashCode(): " + car1.hashCode());
        System.out.println("car2.hashCode(): " + car2.hashCode());
        System.out.println();

        // Демонстрация Lombok - геттеры и сеттеры работают автоматически
        System.out.println("Демонстрация Lombok геттеров/сеттеров:");
        System.out.println("Бренд первого авто: " + firstCar.getBrand());
        System.out.println("Мощность до изменения: " + firstCar.getPower());
        firstCar.setPower(250);
        System.out.println("Мощность после изменения: " + firstCar.getPower());
        System.out.println();

        // Демонстрация особенностей PerformanceCar
        System.out.println("Особенности PerformanceCar:");
        System.out.println("Базовая мощность McLaren: 500, итоговая: " + performanceCar.getPower());
        System.out.println("Модификации: " + String.join(", ", performanceCar.getAddOns()));

        System.out.println("\n=== Тестирование завершено ===");
    }
}