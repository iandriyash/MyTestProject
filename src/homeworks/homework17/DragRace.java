package homeworks.homework17;

import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public class DragRace extends Race {

    public DragRace(int length, String route, int prizeFund, Car[] participants) {
        super(length, route, prizeFund, participants);
    }

    @Override
    public String toString() {
        return "DragRace{" +
                "length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizeFund=" + getPrizeFund() +
                ", participants=" + Arrays.toString(getParticipants()) +
                '}';
    }
}