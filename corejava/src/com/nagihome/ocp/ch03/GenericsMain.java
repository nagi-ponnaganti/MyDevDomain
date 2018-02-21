package com.nagihome.ocp.ch03;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(String.valueOf(1));

        for(Object s : list) {
            System.out.println(s);
        }

    }

}
