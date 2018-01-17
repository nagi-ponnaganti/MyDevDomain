package com.nagihome.oca.ch02;

public class Ch02Main {

    public static void main(String[] args) {

        byte x = 5;
        byte y = 10;

        int a = x + y;
        long b = x + y;
        double c = x + y;

        System.out.printf("a: %s b: %s c: %s\n", a, b, c);

/*        for(int i=0;i<10;){
            i=i++;
            System.out.println("Hello World " + i);
        }*/

        byte e = 50;
        byte f = 40;
        byte g = (byte) (e + f);
        System.out.printf("e: %s f: %s g: %s\n", e, f, g);

        System.out.printf("1 mod 2 : %s ", String.valueOf(1 % 2));

    }

}
