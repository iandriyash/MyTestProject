package homeworks.homework07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> regularProducts = new ArrayList<>();
        List<Product> discountProducts = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("END")) {
                break; // выход из цикла ввода
            }
            if (line.isEmpty()) {
                continue; // пропустить пустые строки
            }

            try {
                Product product;
                if (line.contains("%")) {
                    // Парсинг строки со скидкой, например: "Торт = 800, 15%"
                    String[] parts = line.split("=", 2);
                    String namePart = parts[0].trim();
                    String priceAndDiscount = parts[1].trim();
                    String[] priceParts = priceAndDiscount.split(",");
                    double price = Double.parseDouble(priceParts[0].trim());
                    String discountStr = priceParts[1].replace("%", "").trim();
                    int discountPercent = Integer.parseInt(discountStr);
                    product = new DiscountProduct(namePart, price, discountPercent);
                } else {
                    // Парсинг обычного продукта "Name = Price"
                    String[] parts = line.split("=", 2);
                    String namePart = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    product = new Product(namePart, price);
                }
                // Добавляем в соответствующий список
                if (product instanceof DiscountProduct) {
                    discountProducts.add(product);
                } else {
                    regularProducts.add(product);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Вывод результатов после ввода "END"
        if (!regularProducts.isEmpty()) {
            System.out.print("Обычные продукты: ");
            for (int i = 0; i < regularProducts.size(); i++) {
                System.out.print(regularProducts.get(i).getName());
                if (i < regularProducts.size() - 1) System.out.print(", ");
            }
            System.out.println();
        } else {
            System.out.println("Обычные продукты:");
        }

        if (!discountProducts.isEmpty()) {
            System.out.print("Акционные продукты: ");
            for (int i = 0; i < discountProducts.size(); i++) {
                System.out.print(discountProducts.get(i).getName());
                if (i < discountProducts.size() - 1) System.out.print(", ");
            }
            System.out.println();
        } else {
            System.out.println("Акционные продукты:");
        }
    }
}