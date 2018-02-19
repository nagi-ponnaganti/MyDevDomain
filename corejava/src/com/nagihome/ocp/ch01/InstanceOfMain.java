package com.nagihome.ocp.ch01;

public class InstanceOfMain {

    public static void main(String[] args) {

        Animal a = new HeavyAnimal();
        HeavyAnimal ha = new Hippo();
        Animal e = new Elephant();
        Hippo h = new Hippo();

        System.out.println("a instanceof HeavyAnimal: " + (a instanceof HeavyAnimal));
        System.out.println("ha instanceof HeavyAnimal: " + (ha instanceof HeavyAnimal));
        System.out.println("e instanceof Animal: " + (e instanceof Animal));
        System.out.println("e instanceof Animal: " + (e instanceof Animal));
        System.out.println("h instanceof Mother: " + (e instanceof Mother));
//        System.out.println("h instanceof Hippo: " + (h instanceof Elephant));
    }

    interface Animal {

    }

    public interface Mother {}


    static class HeavyAnimal implements Animal {
    }

    static class Hippo extends HeavyAnimal {
    }

    static class Elephant extends HeavyAnimal {
    }

}
