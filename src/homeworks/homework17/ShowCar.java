package homeworks.homework17;

import java.util.Objects;

public class ShowCar extends Car {
    private int stars;

    // Конструктор с параметрами
    public ShowCar(String brand, String model, int year, int power, int acceleration,
                   int suspension, int durability, int stars) {
        super(brand, model, year, power, acceleration, suspension, durability);
        this.stars = stars;
    }

    // Конструктор только со stars
    public ShowCar(int stars) {
        super();
        this.stars = stars;
    }

    // Пустой конструктор
    public ShowCar() {
        super();
        this.stars = 0;
    }

    // Геттеры и сеттеры
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", power=" + getPower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", stars=" + stars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}