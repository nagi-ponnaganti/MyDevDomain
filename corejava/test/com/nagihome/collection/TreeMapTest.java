package com.nagihome.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class TreeMapTest {

    private TreeMap<Integer, String> map;

    @Before
    public void init() {
        map = new TreeMap<>();
    }

    @Test
    public void testConstructors() {
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        assertTrue(map.size() == 3);
        assertTrue(map.keySet().iterator().next() == 1);
        assertTrue(map.values().containsAll(Arrays.asList(new String[]{"one", "two", "three"})));

        Map<Integer, String> tempMap = map;
        map = new TreeMap<>(Comparator.reverseOrder());
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        assertTrue(map.keySet().iterator().next() == 3);

        map = new TreeMap<>(tempMap);
        assertTrue(map.size() == 3);
        assertTrue(map.keySet().iterator().next() == 1);

    }


    @Test(expected = NullPointerException.class)
    public void testCeilingOps() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(7, "7");

        assertTrue(map.ceilingEntry(4).getKey().equals(4));
        assertTrue(map.ceilingEntry(6).getKey().equals(7));
        assertTrue(map.ceilingKey(6).equals(7));
        System.out.println(map.clone());
        assertNull(map.comparator());
        assertNotNull(map.ceilingEntry(null));
    }

    @Test
    public void testContainsOps() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(4));
        try {
            assertTrue(map.containsKey(null));
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception");
        }

        try {
            assertTrue(map.containsKey("1"));
        } catch (ClassCastException e) {
            System.out.println("Class Cast Exception");
        }

        assertTrue(map.containsValue("1"));
        assertFalse(map.containsValue("4"));
    }


    @Test
    public void testDescendingKeySet() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        assertTrue(map.descendingKeySet().iterator().next().equals(3));
        assertTrue(map.descendingKeySet().remove(1));
        assertTrue(map.size() == 2);
    }

    @Test
    public void testDescendingMap() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        assertTrue(map.descendingMap().entrySet().iterator().next().getKey().equals(3));
        assertNotNull(map.descendingMap().comparator());
    }


    @Test
    public void testGetOps() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, null);

        assertTrue(map.get(2).equals("2"));
        assertNull(map.get(4));
    }


    @Test(expected = NoSuchElementException.class)
    public void testFirstOps() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        assertTrue(map.firstKey().equals(1));
        assertTrue(map.firstEntry().getKey().equals(1));
        map.clear();

        map.firstKey();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubMap() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(8, "8");


        assertTrue(map.subMap(1, true, 3, false).entrySet().iterator().next().getKey().equals(1));
        assertTrue(map.subMap(1, true, 3, false).descendingKeySet().iterator().next().equals(2));
        assertFalse(map.subMap(1, true, 3, false).descendingKeySet().iterator().next().equals(3));
        assertTrue(map.subMap(1, true, 1, true).entrySet().iterator().next().getKey().equals(1));
        assertTrue(map.subMap(1, true, 1, false).size() == 0);
        Map<Integer, String> subMap = map.subMap(1, true, 3, true);
        subMap.put(1, "One");
        assertTrue(map.get(1).equals("One"));
        subMap.put(7, "7");
        assertTrue(map.get(7).equals("7"));
        subMap.put(9, "9");
    }

    @Test
    public void testHeadTailMap() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(8, "8");

        assertTrue(map.headMap(3).size() == 2);
        assertTrue(map.headMap(3).keySet().iterator().next().equals(1));
        assertTrue(map.headMap(3, true).descendingKeySet().iterator().next().equals(3));
        System.out.println(map.tailMap(4, false));
        assertTrue(map.tailMap(4).size() == 4);
    }


    @Test(expected = ConcurrentModificationException.class)
    public void testEntrySet() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(8, "8");

        assertTrue(map.keySet().size() == 7);
        assertTrue(map.keySet().iterator().next() == 1);
        Spliterator<Integer> spliterator = map.keySet().spliterator();
        map.put(7, "7");
        assertTrue(spliterator.estimateSize() == 8);

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            map.put(9, "9");
        }
    }

    @Test
    public void testFirstLastKeyEntry() {
        map.put(1, "1");
        map.put(2, "2");

        assertTrue(map.firstEntry().getKey().equals(1));
        assertTrue(map.lastEntry().getKey().equals(2));
        assertTrue(map.firstKey().equals(1));
        assertTrue(map.lastKey().equals(2));
        map.clear();
        assertNull(map.firstEntry());
        assertNull(map.lastEntry());
    }


}
