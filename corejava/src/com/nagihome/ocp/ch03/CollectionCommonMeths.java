package com.nagihome.ocp.ch03;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionCommonMeths {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        System.out.println("Adding: " + strList.add("Nagi"));
        System.out.println("Adding: " + strList.add("Ponnaganti"));
        System.out.println("Adding: " + strList.add(null));
        System.out.println("List: " + strList);

        System.out.println("Removing: " + strList.remove(null));
        System.out.println("List: " + strList);

        Set<String> set = new HashSet<>();
        System.out.println("Adding: " + set.add("Moni"));
        System.out.println("Adding: " + set.add("Gutta"));
        System.out.println("Adding: " + set.add("Moni"));
        System.out.println("Adding: " + set.add(null));
        System.out.println("set: " + set);

        System.out.println("Removing: " + set.remove(null));
        System.out.println("set: " + set);

        NavigableSet<Integer> navigableSet = new TreeSet<>();
        IntStream.range(0, 20).forEach(i -> navigableSet.add(i));
        System.out.println(navigableSet.lower(10));
        System.out.println(navigableSet.floor(10));
        System.out.println(navigableSet.higher(10));
        System.out.println(navigableSet.ceiling(10));

        ArrayDeque<Integer> intQueue = new ArrayDeque<>();
        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);
        intQueue.add(4);

        System.out.print("Push: ");
        intQueue.push(0);
        System.out.println(intQueue);
        intQueue.clear();

        System.out.println("Poll: " + intQueue.poll());
        System.out.println(intQueue);

        System.out.println("Peek: " + intQueue.peek());
        System.out.println(intQueue);

        System.out.println("Pop: " + intQueue.pop());
        System.out.println(intQueue);


    }

}
