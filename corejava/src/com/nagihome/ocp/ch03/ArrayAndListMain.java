package com.nagihome.ocp.ch03;

import java.util.Arrays;
import java.util.List;

public class ArrayAndListMain {

    public static void main(String[] args) {

        String[] strArray = {"Nagi", "Ponnaganti"};
        List<String> strList = Arrays.asList(strArray);

        System.out.println("strArray: " + Arrays.toString(strArray));
        System.out.println("strList: " + strList.toString());

        strArray[1] = "Gutta";

        System.out.println("strArray: " + Arrays.toString(strArray));
        System.out.println("strList: " + strList.toString());

        strList.set(0, "Monika");

        System.out.println("strArray: " + Arrays.toString(strArray));
        System.out.println("strList: " + strList.toString());

//        strList.add("NewString"); //UnsupportedOperationException
//        strList.remove(0); //UnsupportedOperationException
        strArray = null;

        System.out.println("strArray: " + Arrays.toString(strArray));
        System.out.println("strList: " + strList.toString());

    }

}
