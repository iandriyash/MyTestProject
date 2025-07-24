package homeworks.homework08;

public class NewProduct {
    private String name;
    private double price;

    // Конструктор
    public NewProduct(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Недопустимое имя продукта!");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Недопустимая стоимость продукта!");
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
        return name + " = " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NewProduct product = (NewProduct) obj;
        return name.equals(product.name) && Double.compare(product.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Double.hashCode(price);
    }
}
