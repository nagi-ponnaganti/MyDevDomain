package com.nagihome.hfdp.ch01;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        setFlyBehaviour(new FlyNoWay());
        setQuackBehaviour(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("This is duck");
    }
}
