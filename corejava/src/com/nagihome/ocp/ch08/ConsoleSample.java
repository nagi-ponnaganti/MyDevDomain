package com.nagihome.ocp.ch08;

import java.io.Console;

public class ConsoleSample {

    public static void main(String[] args) {

        Console c = System.console();

        if(c != null) {
            System.out.print("Enter Something: ");
            String input = c.readLine();
            c.writer().printf("You have entered: " + input);
        }

    }

}
