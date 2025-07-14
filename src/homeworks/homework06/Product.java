package homeworks.homework06;

public class Product {
    private String name;
    private double price;

    // Конструктор
    public Product(String name, double price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
        }
        this.name = name;
        this.price = price;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " за " + price + " рублей";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        homeworks.homework06.Product product = (homeworks.homework06.Product) obj;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + Double.hashCode(price);
    }
}
