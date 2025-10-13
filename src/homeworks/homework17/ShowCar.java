package homeworks.homework17;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int year, int power, int acceleration,
                   int suspension, int durability, int stars) {
        super(brand, model, year, power, acceleration, suspension, durability);
        this.stars = stars;
    }

    public ShowCar(int stars) {
        super();
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
}