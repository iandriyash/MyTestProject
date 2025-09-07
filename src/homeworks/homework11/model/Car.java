package homeworks.homework11.model;

public class Car {
    private String number;
    private String model;
    private String color;
    private long mileage;
    private long cost;

    // Конструкторы
    public Car() {}

    public Car(String number, String model, String color, long mileage, long cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    // Геттеры
    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public long getMileage() {
        return mileage;
    }

    public long getCost() {
        return cost;
    }

    // Сеттеры
    public void setNumber(String number) {
        this.number = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-10s %-8s %-8d %d", number, model, color, mileage, cost);
    }

    // Дополнительный метод для создания Car из строки
    public static Car fromString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 5) {
            return new Car(
                    parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim(),
                    Long.parseLong(parts[3].trim()),
                    Long.parseLong(parts[4].trim())
            );
        }
        throw new IllegalArgumentException("Invalid car data format: " + line);
    }
}

