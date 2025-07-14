package homeworks.homework06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример создания продуктов
        homeworks.homework06.Product bread = new homeworks.homework06.Product("Хлеб", 40);
        homeworks.homework06.Product milk = new homeworks.homework06.Product("Молоко", 60);
        homeworks.homework06.Product cake = new homeworks.homework06.Product("Торт", 1000);
        homeworks.homework06.Product coffee = new homeworks.homework06.Product("Кофе растворимый", 879);
        homeworks.homework06.Product butter = new homeworks.homework06.Product("Масло", 150);

        // Пример создания покупателей
        System.out.print("Введите имя покупателя: ");
        String name = scanner.nextLine();
        System.out.print("Введите сумму денег покупателя: ");
        double money = Double.parseDouble(scanner.nextLine());
        homeworks.homework06.Person pavel = new homeworks.homework06.Person(name, money);

        System.out.print("Введите имя покупателя: ");
        name = scanner.nextLine();
        System.out.print("Введите сумму денег покупателя: ");
        money = Double.parseDouble(scanner.nextLine());
        homeworks.homework06.Person anna = new homeworks.homework06.Person(name, money);

        System.out.print("Введите имя покупателя: ");
        name = scanner.nextLine();
        System.out.print("Введите сумму денег покупателя: ");
        money = Double.parseDouble(scanner.nextLine());
        homeworks.homework06.Person boris = new homeworks.homework06.Person(name, money);

        // Продукты, которые можно выбрать
        homeworks.homework06.Product[] products = {bread, milk, cake, coffee, butter};

        // Цикл выбора продуктов
        String input;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\nВведите имя покупателя (или END для завершения): ");
            input = scanner.nextLine().trim();

            // Проверяем, если введено END, завершаем программу
            if (input.equalsIgnoreCase("END")) {
                keepRunning = false;
                break;
            }

            // Ищем покупателя
            Person currentPerson = null;
            if (input.equalsIgnoreCase(pavel.getName())) {
                currentPerson = pavel;
            } else if (input.equalsIgnoreCase(anna.getName())) {
                currentPerson = anna;
            } else if (input.equalsIgnoreCase(boris.getName())) {
                currentPerson = boris;
            } else {
                System.out.println("Такого покупателя нет. Попробуйте снова.");
                continue;
            }

            System.out.println("Продукты для выбора: ");
            for (homeworks.homework06.Product product : products) {
                System.out.println("- " + product.getName() + " за " + product.getPrice() + " рублей");
            }

            System.out.print("Введите название продукта, который хотите купить: ");
            input = scanner.nextLine().trim();

            boolean productFound = false;
            // Ищем выбранный продукт
            for (Product product : products) {
                if (input.equalsIgnoreCase(product.getName())) {
                    currentPerson.addProductToBasket(product);
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
                System.out.println("Продукт не найден, попробуйте снова.");
            }
        }

        // Вывод корзины покупателей
        pavel.printBasket();
        anna.printBasket();
        boris.printBasket();

        // Закрытие сканнера
        scanner.close();
    }
}
