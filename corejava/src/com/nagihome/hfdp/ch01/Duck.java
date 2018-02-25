package com.nagihome.hfdp.ch01;

public abstract class Duck {

    private FlyBehaviour flyBehaviour;
    private QuackBehaviour quackBehaviour;

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public abstract void display();

    public void swim() {
        System.out.println("Even the decoys can swim");
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

}
