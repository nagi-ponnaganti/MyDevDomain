package com.nagihome.hfdp.ch02;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(o -> o.update(temperature, humidity, pressure));
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
