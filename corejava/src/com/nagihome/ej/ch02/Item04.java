package com.nagihome.ej.ch02;

public class Item04 {

    public static void main(String[] args) {
        UtilityClass.getUtility();
        new UtilityClass();
    }


    static class UtilityClass {
        public static void getUtility() {

        }

        private UtilityClass() {
            throw new AssertionError("Instance Can't be Created");
        }
    }

}
