package com.nagihome.hfdp.ch14.bridge;

public class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Rectangle with ");
        color.applyColor();
    }

}
