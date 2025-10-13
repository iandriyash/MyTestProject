package homeworks.homework17;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String brand;
    private String model;
    private int year;
    private int power;
    private int acceleration;
    private int suspension;
    private int durability;

    // Lombok автоматически создаст:
    // - все геттеры и сеттеры
    // - toString()
    // - equals() и hashCode()
    // - конструктор с параметрами (@AllArgsConstructor)
    // - пустой конструктор (@NoArgsConstructor)
}