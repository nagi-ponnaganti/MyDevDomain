package com.nagihome.beghib.ch06;

import javax.persistence.Embeddable;

@Embeddable
public class Publisher {

    private String name;
    private Location location;

    public Publisher(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
