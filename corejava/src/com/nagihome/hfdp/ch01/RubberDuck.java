package com.nagihome.hfdp.ch01;

public class RubberDuck extends Duck {

    public RubberDuck() {
        setFlyBehaviour(new FlyNoWay());
        setQuackBehaviour(new Squeak());
    }

    @Override
    public void display() {
        System.out.println("I'm Rubber Duck");
    }
}
