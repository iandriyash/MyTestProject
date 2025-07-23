package homeworks.homework07;

import java.util.Objects;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        // Проверка названия
        if (name == null || name.trim().isEmpty() || name.matches("\\d+")) {
            throw new IllegalArgumentException("Недопустимое имя продукта!");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Недопустимое имя продукта!");
        }
        // Проверка цены
        if (price <= 0) {
            throw new IllegalArgumentException("Недопустимая стоимость продукта!");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " = " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}