package com.nagihome.ocp.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInSample {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            System.out.print("Enter Something: ");
            String input = reader.readLine();
            System.out.println("You have entered : " + input);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
