package homeworks.homework09;

import java.util.Arrays;

public class DriftRace extends Race {

    // Конструктор с параметрами
    public DriftRace(int length, String route, int prizeFund, Car[] participants) {
        super(length, route, prizeFund, participants);
    }

    // Пустой конструктор
    public DriftRace() {
        super();
    }

    @Override
    public String toString() {
        return "DriftRace{" +
                "length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizeFund=" + getPrizeFund() +
                ", participants=" + Arrays.toString(getParticipants()) +
                '}';
    }
}
