package com.nagihome.concurrent.api;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeTest {

    @Test
    public void testCapacity() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);
        System.out.println("Capacity: " + deq.remainingCapacity());
        assertEquals(2, deq.remainingCapacity());

        deq = new LinkedBlockingDeque<>();
        assertEquals(Integer.MAX_VALUE, deq.remainingCapacity());
    }

    @Test(expected = IllegalStateException.class)
    public void testAboveCapacity() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);
        deq.add("Nagi");
        deq.add("Ponnaganti");
        deq.add("Hello");
    }

    @Test
    public void testCollectionContructor() {
        List<String> list = new ArrayList<>();
        list.add("Nagi");
        list.add("Ponnaganti");
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(list);
        System.out.println(deq);
        assertEquals(list.size(), deq.size());
        assertEquals(list.get(0), deq.getFirst());
    }

    @Test
    public void testAddMethod() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(3);
        deq.add("Nagi");
        deq.add("Ponnaganti");

        assertEquals(deq.getFirst(), "Nagi");
        assertEquals(deq.getLast(), "Ponnaganti");
        assertTrue(deq.size() > deq.remainingCapacity());
        assertTrue(deq.remainingCapacity() == 1);
        assertTrue(deq.add("Hello"));

    }

    @Test(expected = IllegalStateException.class)
    public void testAddMethodForIllegialStateException() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(1);
        deq.add("Nagi");
        deq.add("Ponnaganti");
    }


    @Test(expected = NullPointerException.class)
    public void testAddMethodNullPointerException() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add(null);
    }

    @Test
    public void testAddFirst() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.addFirst("Nagi");
        deq.addFirst("Ponnaganti");

        assertTrue(deq.remainingCapacity() == Integer.MAX_VALUE - 2);
        assertTrue(deq.getFirst() == "Ponnaganti");
    }

    @Test
    public void testAddLast() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.addLast("Nagi");
        deq.addLast("Ponnaganti");

        assertTrue(deq.getFirst().equals("Nagi"));
    }

    @Test
    public void testClear() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);
        deq.add("Nagi");
        deq.add("Ponnaganti");
        assertTrue(deq.size() == 2);
        deq.clear();
        assertTrue(deq.size() == 0);
        assertTrue(deq.remainingCapacity() == 2);
    }

    @Test
    public void testContains() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);
        deq.add("Nagi");
        deq.add("Nagi");
        assertTrue(deq.contains("Nagi"));
        assertFalse(deq.contains("nagi"));
    }


    @Test
    public void testDescendingIterator() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(5);
        deq.add("Message 01");
        deq.add("Message 02");

        Iterator<String> it = deq.descendingIterator();
        assertTrue(it.hasNext());
        assertTrue(it.next().equals("Message 02"));
        assertTrue(it.next().equals("Message 01"));
        assertFalse(it.hasNext());

        it = deq.descendingIterator();
        deq.add("Message 03");
        int count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }

        assertTrue(count == 2);
    }

    @Test
    public void testDrainTo() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Message 01");
        deq.add("Message 02");
        deq.add("Message 02");

        Set<String> set = new HashSet<>();
        deq.drainTo(set);

        assertTrue(set.size() == 2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDrainToUnSupportedOperation() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Mesasge 01");
        deq.add("Message 02");

        Set<String> unModSet = Collections.unmodifiableSet(new HashSet<>());
        deq.drainTo(unModSet);

    }

    @Test(expected = ClassCastException.class)
    public void testDrainToClassCastException() {
        LinkedBlockingDeque deq = new LinkedBlockingDeque();
        deq.add("a");
        deq.add("1");
        Set<Integer> set = new HashSet<>();
        deq.drainTo(set);
        set.stream().reduce(0, (a, b) -> a + b);
    }

    @Test
    public void testDrainToMaxElements() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Nagi");
        deq.add("Moni");
        deq.add("Gutta");
        deq.add("Ponnaganti");

        Set<String> set = new HashSet<>();
        deq.drainTo(set, 2);
        assertTrue(set.size() == 2);
        assertTrue(set.contains("Nagi") && set.contains("Moni"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDrainToSameDeque() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Nagi");
        deq.add("Moni");

        deq.drainTo(deq, 2);
    }


    @Test(expected = NoSuchElementException.class)
    public void testElement() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Nagi");
        deq.add("Ponnaganti");

        assertTrue(deq.element().equals("Nagi"));
        assertTrue(deq.size() == 2);

        deq.clear();
        deq.element();
    }

    @Test
    public void testGetFirst() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Nagi");
        deq.add("Ponnaganti");

        assertTrue(deq.getFirst().equals("Nagi"));
        assertTrue(deq.size() == 2);
    }

    @Test
    public void testGetLast() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Nagi");
        deq.add("Ponnaganti");

        assertTrue(deq.getLast().equals("Ponnaganti"));
        assertTrue(deq.size() == 2);
    }

    @Test
    public void testIterator() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.add("Nagi");
        deq.add("Ponnaganti");

        Iterator<String> it = deq.iterator();
        int count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }

        assertTrue(count == 2);
    }

    @Test
    public void testOffer() {

        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);
        deq.offer("Nagi");
        deq.offer("Ponnaganti");

        assertTrue(deq.peek().equals("Nagi"));
        assertTrue(deq.size() == 2);

        assertFalse(deq.offer("Hello"));
    }

    @Test
    public void testOfferWithTimeout() throws InterruptedException {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);
        deq.offer("Nagi");
        deq.offer("Ponnaganti");
        deq.offer("Hello", 1, TimeUnit.SECONDS);

        assertTrue(deq.size() == 2);
        assertFalse(deq.contains("Hello"));
    }

    @Test
    public void testOfferFirst() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.offerFirst("Nagi");
        deq.offerFirst("Ponnaganti");

        assertTrue(deq.peek().equals("Ponnaganti"));
    }


    @Test
    public void testOfferFirstWithTimeout() throws InterruptedException {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);
        deq.offerFirst("Nagi");
        deq.offerFirst("Ponnaganti");

        assertTrue(deq.peek().equals("Ponnaganti"));
        assertFalse(deq.offerFirst("Hello", 1, TimeUnit.SECONDS));
    }

    @Test
    public void testOfferLastWithTimeout() throws InterruptedException {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(2);

        deq.offerLast("Nagi");
        deq.offerLast("Ponnaganti");

        assertTrue(deq.peek().equals("Nagi"));
        assertFalse(deq.offerLast("Hello", 1, TimeUnit.SECONDS));
    }

    @Test
    public void testPeek() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.offer("Nagi");
        deq.offer("Ponnaganti");

        assertTrue(deq.peek().equals("Nagi"));
        deq.clear();

        assertNull(deq.peek());
    }

    @Test
    public void testPeekFirst() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.offer("Nagi");
        deq.offer("Ponnaganti");

        assertTrue(deq.peekFirst().equals("Nagi"));
    }

    @Test
    public void peekLast() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.offer("Nagi");
        deq.offer("Ponnaganti");

        assertTrue(deq.peekLast().equals("Ponnaganti"));
    }

    @Test
    public void testAllPollOps() throws InterruptedException {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.offer("Nagi");
        deq.offer("Ponnaganti");

        assertTrue(deq.poll().equals("Nagi"));
        assertTrue(deq.size() == 1);
        assertNotNull(deq.poll());
        assertNull(deq.poll(1, TimeUnit.SECONDS));

        deq.offer("Nagi");
        deq.offer("Ponnaganti");
        deq.offer("Hello");

        assertTrue(deq.pollFirst().equals("Nagi"));
        assertTrue(deq.pollLast().equals("Hello"));
        deq.clear();

        assertNull(deq.pollFirst(1, TimeUnit.SECONDS));
        assertNull(deq.pollLast(1, TimeUnit.SECONDS));
    }

    @Test
    public void testStackOps() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.push("Nagi");
        deq.push("Ponnaganti");

        assertTrue(deq.peek().equals("Ponnaganti"));
        assertTrue(deq.pop().equals("Ponnaganti"));
        assertTrue(deq.pop().equals("Nagi"));
    }

    @Test(expected = NullPointerException.class)
    public void testBlockOps() throws InterruptedException {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>(4);
        deq.put("Nagi");
        deq.put("Ponnaganti");

        assertTrue(deq.size() == 2);
        assertTrue(deq.peek().equals("Nagi"));
        deq.putFirst("Hello");
        assertTrue(deq.peekFirst().equals("Hello"));
        deq.putLast("World");
        assertTrue(deq.peekLast().equals("World"));

        assertTrue(deq.take().equals("Hello"));
        assertTrue(deq.takeFirst().equals("Nagi"));
        assertTrue(deq.takeLast().equals("World"));
        deq.putLast(null);
    }

    @Test
    public void testRemoveOps() {
        LinkedBlockingDeque<String> deq = new LinkedBlockingDeque<>();
        deq.offer("Message 01");
        deq.offer("Message 02");
        deq.offer("Message 03");
        deq.offer("Message 04");

        assertTrue(deq.remove().equals("Message 01"));
        assertTrue(deq.removeFirst().equals("Message 02"));
        assertTrue(deq.removeLast().equals("Message 04"));

        deq.offerFirst("Message 02");
        deq.offerFirst("Message 03");
        deq.offerFirst("Message 02");

        deq.removeFirstOccurrence("Message 03");
        assertTrue(deq.size() == 3);
        deq.removeLastOccurrence("Message 02");
        assertTrue(deq.peek().equals("Message 02"));

    }




}
