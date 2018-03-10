package com.nagihome.springboot.hazelcast.ch02;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class City implements Serializable, Comparable<City> {

    private String name;
    private String country;
    private int population;

    @Override
    public int compareTo(City city) {
        return this.population - city.getPopulation();
    }
}
