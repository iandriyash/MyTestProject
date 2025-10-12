package homeworks.homework17;

import java.util.Arrays;

public class CasualRace extends Race {

    // Конструктор с параметрами
    public CasualRace(int length, String route, int prizeFund, Car[] participants) {
        super(length, route, prizeFund, participants);
    }

    // Пустой конструктор
    public CasualRace() {
        super();
    }

    @Override
    public String toString() {
        return "CasualRace{" +
                "length=" + getLength() +
                ", route='" + getRoute() + '\'' +
                ", prizeFund=" + getPrizeFund() +
                ", participants=" + Arrays.toString(getParticipants()) +
                '}';
    }
}
