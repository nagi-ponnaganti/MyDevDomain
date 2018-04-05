package com.nagihome.hfdp.ch06;

public class Hottub {

    private boolean on;
    private int temperature;

    public Hottub() {
    }

    public void on() {
        on = true;
    }

    public void off() {
        on = true;
    }

    public void jetsOn() {
        if (on)
            System.out.println("Jets Are On");
    }

    public void jetsOff() {
        if (on)
            System.out.println("Jets Are Off");
    }

    public void bubblesOn() {
        if (on)
            System.out.println("Bubbles Are On");
    }

    public void bubblesOff() {
        if (on)
            System.out.println("Bubbles Are Off");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void cool() {
        temperature = 98;
        System.out.println("Hottub is cooling to 98 degrees");
    }

    public void heat() {
        temperature = 105;
        System.out.println("Hottub is heating to a steaming 105 degrees");
    }
}
