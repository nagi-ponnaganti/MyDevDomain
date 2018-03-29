package com.nagihome.hfdp.ch01;

public class ModelDuck extends Duck {

    public ModelDuck() {
        setFlyBehaviour(new FlyNoWay());
        setQuackBehaviour(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("This is Model Duck");
    }
}
