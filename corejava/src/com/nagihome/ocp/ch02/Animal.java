package com.nagihome.ocp.ch02;

import java.util.List;

public class Animal {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        this.favoriteFoods = favoriteFoods;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", age=" + age +
                ", favoriteFoods=" + favoriteFoods +
                '}';
    }

    public Animal() {
    }

}