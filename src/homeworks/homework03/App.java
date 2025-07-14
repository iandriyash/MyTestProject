package homeworks.homework03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите марку телевизора:");
        String brand = scanner.nextLine();

        System.out.println("Введите модель телевизора:");
        String model = scanner.nextLine();

        System.out.println("Введите размер экрана (в дюймах):");
        int screenSize = scanner.nextInt();

        System.out.println("Введите цену (в рублях):");
        double price = scanner.nextDouble();

        Television tv = new Television(brand, model, screenSize, price);
        System.out.println(tv);
    }
}