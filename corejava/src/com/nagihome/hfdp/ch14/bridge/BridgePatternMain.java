package com.nagihome.hfdp.ch14.bridge;

public class BridgePatternMain {

    public static void main(String[] args) {
        Color redColor = new RedColor();
        Color greenColor = new GreenColor();

        Shape triangle = new Triangle(redColor);
        Shape rectangle = new Rectangle(greenColor);

        triangle.applyColor();
        rectangle.applyColor();
    }
}
