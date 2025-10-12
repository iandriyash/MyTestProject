package homeworks.homework17;

import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public class CasualRace extends Race {

    public CasualRace(int length, String route, int prizeFund, Car[] participants) {
        super(length, route, prizeFund, participants);
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