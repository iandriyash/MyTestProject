package homeworks.homework17;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PerformanceCar extends Car {
    private String[] addOns;

    public PerformanceCar(String brand, String model, int year, int power, int acceleration,
                          int suspension, int durability, String[] addOns) {
        super(brand, model, year, power, acceleration, suspension, durability);
        this.addOns = addOns != null ? addOns : new String[0];
        // Увеличиваем мощность на 50%
        super.setPower((int) (power * 1.5));
        // Уменьшаем подвеску на 25%
        super.setSuspension((int) (suspension * 0.75));
    }

    public PerformanceCar(String[] addOns) {
        super();
        this.addOns = addOns != null ? addOns : new String[0];
        int basePower = super.getPower();
        int baseSuspension = super.getSuspension();
        super.setPower((int) (basePower * 1.5));
        super.setSuspension((int) (baseSuspension * 0.75));
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
}