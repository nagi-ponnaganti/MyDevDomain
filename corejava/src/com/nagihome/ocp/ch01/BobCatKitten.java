package com.nagihome.ocp.ch01;

import java.io.IOException;

public class BobCatKitten extends BobCat {

    public Integer findDen() throws IOException {
        System.out.println("findDen ");
        return new Integer(4);
    }

    /*public void findDen(int i) {
        System.out.println("findDen int i ");
    }*/

/*    public void findDen(Integer i) {
        System.out.println("findDen integer i ");
    }*/

/*    public void findDen(Long i) {
        System.out.println("findDen Long i ");
    }*/
/*
    public void findDen(Number i) {
        System.out.println("findDen number i ");
    }*/

/*
    public void findDen(long i) {
        System.out.println("findDen long i ");
    }*/

    public static void main(String[] args) throws IOException {
        BobCatKitten bcc = new BobCatKitten();

        bcc.findDen();
    }

}
