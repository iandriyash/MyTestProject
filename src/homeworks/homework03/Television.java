package homeworks.homework03;

public class Television {
    private String brand;
    private String model;
    private int screenSize; // в дюймах
    private double price;   // в рублях

    // Конструктор
    public Television(String brand, String model, int screenSize, double price) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.price = price;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public double getPrice() {
        return price;
    }

    // Сеттеры
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return "Телевизор [Марка: " + brand + ", Модель: " + model + ", Размер экрана: " + screenSize + " дюймов, Цена: " + price + " руб.]";
    }
}