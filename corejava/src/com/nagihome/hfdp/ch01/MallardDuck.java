package com.nagihome.hfdp.ch01;

public class MallardDuck extends Duck {

    public MallardDuck() {
        setFlyBehaviour(new FlyWithWings());
        setQuackBehaviour(new Quack());
    }

    @Override
    public void display() {
        System.out.println("Mallard Duck Display");
    }
}
