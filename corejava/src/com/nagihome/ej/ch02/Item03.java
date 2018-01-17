package com.nagihome.ej.ch02;

public class Item03 {

    public static void main(String[] args) {
        Elvis elvis = Elvis.getSingleInstance();
        elvis.leaveThisBuilding();
    }

    static class Elvis {
        private static final Elvis SINGLE_INSTANCE = new Elvis();

        private Elvis() {

        }

        public static Elvis getSingleInstance() {
            return SINGLE_INSTANCE;
        }

        public void leaveThisBuilding() {
            System.out.println("Leave This Building is Invoked");
        }
    }

}

