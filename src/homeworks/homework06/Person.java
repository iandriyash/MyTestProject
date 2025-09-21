package homeworks.homework06;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<homeworks.homework06.Product> basket;

    // Конструктор
    public Person(String name, double money) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.name = name;
        this.money = money;
        this.basket = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void addProductToBasket(Product product) {
        if (product.getPrice() <= money) {
            basket.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил " + product.getName());
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
        }
    }

    // Печать содержимого корзины
    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println(name + " - Ничего не куплено");
        } else {
            System.out.print(name + " - ");
            for (int i = 0; i < basket.size(); i++) {
                System.out.print(basket.get(i).getName());
                if (i < basket.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return name + " имеет " + money + " рублей";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        homeworks.homework06.Person person = (homeworks.homework06.Person) obj;
        return Double.compare(person.money, money) == 0 && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + Double.hashCode(money);
    }
}
