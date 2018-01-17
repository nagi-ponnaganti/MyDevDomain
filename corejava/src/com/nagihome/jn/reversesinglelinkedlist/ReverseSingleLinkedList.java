package com.nagihome.jn.reversesinglelinkedlist;

public class ReverseSingleLinkedList {

    public static void main(String a[]) {
        SingleLinkedListImpl<Integer> sl = new SingleLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        System.out.println();
        sl.traverse();
        System.out.println();
        sl.reverse();
        sl.traverse();
    }
}
