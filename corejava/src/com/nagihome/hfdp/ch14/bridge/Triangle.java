package com.nagihome.hfdp.ch14.bridge;

public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle with ");
        color.applyColor();
    }
}
