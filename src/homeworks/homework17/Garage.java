package homeworks.homework17;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Garage {
    private Car[] parkedCars;

    // Конструктор с параметрами
    public Garage(Car[] parkedCars) {
        this.parkedCars = parkedCars != null ? parkedCars : new Car[0];
    }

    // Пустой конструктор
    public Garage() {
        this.parkedCars = new Car[0];
    }

    // Метод модификации автомобиля (как в примере преподавателя)
    public void modificateCar(int carNumber) {
        if (carNumber < 0 || carNumber >= parkedCars.length) {
            System.out.println("Неверный номер автомобиля");
            return;
        }

        Car car = parkedCars[carNumber];
        System.out.println(car.toString());
        System.out.println("Выберите какой параметр хотите изменить: мощность");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextLine().toLowerCase()) {
            case "мощность" -> {
                System.out.print("Введите новое значение мощности: ");
                int newPower = scanner.nextInt();
                car.setPower(newPower);
                System.out.println("Мощность изменена на: " + newPower);
            }
            default -> System.out.println("Выбран не верный параметр");
        }
    }

    // Геттеры и сеттеры
    public Car[] getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars != null ? parkedCars : new Car[0];
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + Arrays.toString(parkedCars) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.deepEquals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(parkedCars);
    }
}
