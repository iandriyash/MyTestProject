package homeworks.homework17;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Garage {
    private Car[] parkedCars = new Car[0];

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

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + Arrays.toString(parkedCars) +
                '}';
    }
}