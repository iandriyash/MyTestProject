package homeworks.homework08;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;

public class NewPerson {
    private String name;
    private double money;
    private List<NewProduct> basket;

    // Конструктор
    public NewPerson(String name, double money) {
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

    // Геттеры
    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<NewProduct> getBasket() {
        return new ArrayList<>(basket);
    }

    // Добавление продукта в корзину
    public boolean addProductToBasket(NewProduct product) {
        if (money >= product.getPrice()) {
            basket.add(product);
            money -= product.getPrice();
            return true;
        }
        return false;
    }

    // Печать корзины покупателя в файл
    public void printBasketToFile(BufferedWriter writer) throws IOException {
        if (basket.isEmpty()) {
            writer.write(name + " - Ничего не куплено\n");
        } else {
            writer.write(name + " - ");
            for (int i = 0; i < basket.size(); i++) {
                writer.write(basket.get(i).getName());
                if (i < basket.size() - 1) {
                    writer.write(", ");
                }
            }
            writer.write("\n");
        }
    }

    @Override
    public String toString() {
        return name + " = " + money;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NewPerson person = (NewPerson) obj;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}