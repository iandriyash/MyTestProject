package homeworks.homework09;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Тестирование системы гонок ===\n");

        // Создание автомобилей
        Car regularCar = new Car("Toyota", "Camry", 2020, 200, 8, 7, 9);
        PerformanceCar performanceCar = new PerformanceCar("Ferrari", "F40", 2021, 400, 5, 8, 7,
                new String[]{"Турбо", "Спойлер"});
        ShowCar showCar = new ShowCar("Lamborghini", "Aventador", 2022, 700, 4, 6, 8, 5);

        System.out.println("Созданные автомобили:");
        System.out.println(regularCar);
        System.out.println(performanceCar);
        System.out.println(showCar);
        System.out.println();

        // Тестирование гаража
        Car[] cars = {regularCar, performanceCar, showCar};
        Garage garage = new Garage(cars);

        System.out.println("Гараж:");
        System.out.println(garage);
        System.out.println();

        // Создание гонок
        Car[] participants = {performanceCar, showCar};
        CasualRace casualRace = new CasualRace(1000, "Городская трасса", 50000, participants);
        DragRace dragRace = new DragRace(400, "Прямая дорога", 100000, participants);
        DriftRace driftRace = new DriftRace(800, "Горная дорога", 75000, participants);

        System.out.println("Созданные гонки:");
        System.out.println(casualRace);
        System.out.println(dragRace);
        System.out.println(driftRace);
        System.out.println();

        // Тестирование equals и hashCode
        Car car1 = new Car("BMW", "M3", 2020, 450, 6, 7, 8);
        Car car2 = new Car("BMW", "M3", 2020, 450, 6, 7, 8);

        System.out.println("Тестирование equals:");
        System.out.println("car1.equals(car2): " + car1.equals(car2));
        System.out.println("car1.hashCode(): " + car1.hashCode());
        System.out.println("car2.hashCode(): " + car2.hashCode());
        System.out.println();

        // Демонстрация модификации в гараже
        System.out.println("Модификация автомобиля в гараже:");
        System.out.println("Мощность до модификации: " + regularCar.getPower());
        regularCar.setPower(250);
        System.out.println("Мощность после модификации: " + regularCar.getPower());

        // Демонстрация особенностей PerformanceCar
        System.out.println("\nОсобенности PerformanceCar:");
        PerformanceCar testPerf = new PerformanceCar("Test", "Car", 2023, 100, 5, 8, 7,
                new String[]{"Нитро"});
        System.out.println("Базовая мощность: 100, итоговая мощность: " + testPerf.getPower());
        System.out.println("Базовая подвеска: 8, итоговая подвеска: " + testPerf.getSuspension());
    }
}