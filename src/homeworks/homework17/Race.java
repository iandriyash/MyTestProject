package homeworks.homework17;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Race {
    private int length;
    private String route;
    private int prizeFund;
    private Car[] participants;

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizeFund=" + prizeFund +
                ", participants=" + Arrays.toString(participants) +
                '}';
    }
}