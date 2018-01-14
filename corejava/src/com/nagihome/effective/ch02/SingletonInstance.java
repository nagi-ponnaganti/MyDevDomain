package com.nagihome.effective.ch02;

public class SingletonInstance {

    public static void main(String[] args) {
        System.out.println(Elvis.INSTANCE);   
    }
}

final class Elvis {
    public final static Elvis INSTANCE = new Elvis();
}
