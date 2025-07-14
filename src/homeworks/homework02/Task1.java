package homeworks.homework02;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите степень в градусах Форенгейта: ");
        double farenheit = sc.nextDouble();
        double celsius = (farenheit - 32) * 5 / 9;
        System.out.println(farenheit + " Градусов по фаренгейту равна " + celsius + " По цельсию");
            }
}
