package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private Random number;
    private boolean isOn =false;
    public TemperatureSensor() {
        this.number = new Random();
    }


    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        isOn = true;
    }

    @Override
    public void setOff() {
        isOn = false;
    }

    @Override
    public int read() {
        if (isOn) {
            return number.nextInt(61) - 30;
        } else {
            throw new IllegalStateException("The sensor is off");
        }
    }
}
