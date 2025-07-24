package homeworks.homework08;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        Map<String, NewProduct> products = new HashMap<>();
        Map<String, NewPerson> people = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            List<String> lines = new ArrayList<>();

            // Читаем все строки файла
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }

            // Первый проход - читаем покупателей и продукты
            // По структуре файла: сначала идут покупатели, потом продукты
            boolean readingProducts = false;

            for (String currentLine : lines) {
                if (currentLine.equalsIgnoreCase("END")) {
                    break;
                }

                if (currentLine.contains("=")) {
                    String[] parts = currentLine.split("=");
                    String name = parts[0].trim();
                    double value = Double.parseDouble(parts[1].trim());

                    // Переключаемся на чтение продуктов, когда встречаем товары
                    // Характерные имена продуктов: Хлеб, Молоко, Торт, и т.д.
                    if (name.equals("Хлеб") || name.equals("Молоко") || name.equals("Торт") ||
                            name.equals("Кофе растворимый") || name.equals("Масло")) {
                        readingProducts = true;
                    }

                    if (!readingProducts) {
                        NewPerson person = new NewPerson(name, value);
                        people.put(name, person);
                    } else {
                        NewProduct product = new NewProduct(name, value);
                        products.put(name, product);
                    }
                }
            }

            // Второй проход - обрабатываем покупки
            boolean processingPurchases = false;
            for (String currentLine : lines) {
                if (currentLine.equalsIgnoreCase("END")) {
                    break;
                }

                // Если строка не содержит "=" и мы уже прочитали данные, значит начались покупки
                if (!currentLine.contains("=") && !people.isEmpty() && !products.isEmpty()) {
                    processingPurchases = true;
                }

                if (processingPurchases) {
                    // Разбираем строку покупки
                    String personName = null;
                    String productName = null;

                    // Проверяем все возможные варианты имен покупателей
                    for (String name : people.keySet()) {
                        if (currentLine.startsWith(name + " ")) {
                            personName = name;
                            productName = currentLine.substring(name.length() + 1);
                            break;
                        }
                    }

                    if (personName != null) {
                        NewPerson person = people.get(personName);
                        NewProduct product = products.get(productName);

                        if (person != null && product != null) {
                            if (person.addProductToBasket(product)) {
                                // Определяем окончание глагола
                                String verb = personName.endsWith("на") ? "купила" : "купил";
                                bufferedWriter.write("%s %s %s\n".formatted(personName, verb, productName));
                            } else {
                                bufferedWriter.write("%s не может позволить себе %s\n".formatted(personName, productName));
                            }
                        }
                    }
                }
            }

            // Выводим итоговые корзины только для покупателей
            for (String personName : people.keySet()) {
                NewPerson person = people.get(personName);
                person.printBasketToFile(bufferedWriter);
            }

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при работе с файлами", e);
        }
    }
}