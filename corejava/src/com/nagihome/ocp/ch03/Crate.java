package com.nagihome.ocp.ch03;

import java.util.ArrayList;
import java.util.List;

public class Crate<T> {

    private T contents;

    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }

    public <K> Crate<T> testDiffParam(K input) {
        return new Crate<>();
    }

    @Override
    public String toString() {
        return "Crate{" +
                "contents=" + contents +
                '}';
    }

    public static void main(String[] args) {
        Crate<Integer> intCrate = new Crate<>();
        intCrate.packCrate(4);
        System.out.println("intCrate: " + intCrate);

        Crate<String> strCrate = new Crate<>();
        strCrate.packCrate("Packed");
        System.out.println("strCrate: " + strCrate);

        Integer[] strArray = new Integer[1];
        strArray[0] = 1;
        Object[] objArray = strArray;
//        objArray[0] = "test";
        System.out.println(objArray[0]);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        printNums(list);

    }

    private static void printNums(List<? extends Number> list) {
        list.forEach(i -> System.out.println("Number: " + i));
    }

}
