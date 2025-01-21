package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> prevReadings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.prevReadings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }


    public List<Integer> readings() {
        return new ArrayList<>(prevReadings);
    }

    @Override
    public boolean isOn() {
        return sensors.stream().allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("Avg cannot be empty and must be set to on");
        }
        int averageReading = (int) sensors.stream()
                .filter(Sensor::isOn)
                .mapToInt(Sensor::read)
                .average().orElse(0);

        prevReadings.add(averageReading);
        return averageReading;
    }
}
