package com.nagihome.ocp.ch02;

import java.util.ArrayList;

public class BuilderPatternMain {


    public static void main(String[] args) {
        Animal ab = new AnimalBuilder().setAge(10).setFavoriteFoods(new ArrayList<>()).setSpecies("masala").build();
        System.out.println(ab);
    }

}


