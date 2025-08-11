package homeworks.homework09;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns;

    // Конструктор с параметрами
    public PerformanceCar(String brand, String model, int year, int power, int acceleration,
                          int suspension, int durability, String[] addOns) {
        super(brand, model, year, power, acceleration, suspension, durability);
        this.addOns = addOns != null ? addOns : new String[0];
        // Увеличиваем мощность на 50%
        super.setPower((int) (power * 1.5));
        // Уменьшаем подвеску на 25%
        super.setSuspension((int) (suspension * 0.75));
    }

    // Конструктор только с addOns
    public PerformanceCar(String[] addOns) {
        super();
        this.addOns = addOns != null ? addOns : new String[0];
        // Применяем модификации к базовым значениям
        int basePower = super.getPower();
        int baseSuspension = super.getSuspension();
        super.setPower((int) (basePower * 1.5));
        super.setSuspension((int) (baseSuspension * 0.75));
    }

    // Пустой конструктор
    public PerformanceCar() {
        super();
        this.addOns = new String[0];
        // Применяем модификации к базовым значениям
        int basePower = super.getPower();
        int baseSuspension = super.getSuspension();
        super.setPower((int) (basePower * 1.5));
        super.setSuspension((int) (baseSuspension * 0.75));
    }

    // Геттеры и сеттеры
    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns != null ? addOns : new String[0];
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", power=" + getPower() +
                ", acceleration=" + getAcceleration() +
                ", suspension=" + getSuspension() +
                ", durability=" + getDurability() +
                ", addOns=" + Arrays.toString(addOns) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Arrays.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(addOns);
        return result;
    }
}
