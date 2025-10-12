package homeworks.homework17;

import java.util.Arrays;
import java.util.Objects;

public class Race {
    private int length;
    private String route;
    private int prizeFund;
    private Car[] participants;

    // Конструктор с параметрами
    public Race(int length, String route, int prizeFund, Car[] participants) {
        this.length = length;
        this.route = route;
        this.prizeFund = prizeFund;
        this.participants = participants != null ? participants : new Car[0];
    }

    // Пустой конструктор
    public Race() {
        this.length = 0;
        this.route = "Unknown";
        this.prizeFund = 0;
        this.participants = new Car[0];
    }

    // Геттеры и сеттеры
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(int prizeFund) {
        this.prizeFund = prizeFund;
    }

    public Car[] getParticipants() {
        return participants;
    }

    public void setParticipants(Car[] participants) {
        this.participants = participants != null ? participants : new Car[0];
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizeFund=" + prizeFund +
                ", participants=" + Arrays.toString(participants) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return length == race.length &&
                prizeFund == race.prizeFund &&
                Objects.equals(route, race.route) &&
                Arrays.equals(participants, race.participants);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length, route, prizeFund);
        result = 31 * result + Arrays.hashCode(participants);
        return result;
    }
}

