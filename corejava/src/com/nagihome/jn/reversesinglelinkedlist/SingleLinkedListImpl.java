package com.nagihome.jn.reversesinglelinkedlist;

public class SingleLinkedListImpl<T> {

    private Node<T> head;

    public void add(T element) {

        Node<T> newNode = new Node<>();
        newNode.setValue(element);

        Node<T> tmp = head;

        while (true) {

            if (tmp == null) {
                head = newNode;
                break;
            } else if (tmp.getNext() == null) {
                tmp.setNext(newNode);
                break;
            } else {
                tmp = tmp.getNext();
            }
        }
    }

    public void traverse() {
        System.out.println();
        Node<T> tmp = head;
        while (true) {
            if (tmp == null) {
                break;
            }

            System.out.print(tmp.getValue() + "\t");
            tmp = tmp.getNext();
        }
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = null;

        while (curr != null) {
            System.out.printf("\nprev: %s curr: %s next: %s",
                    ((prev != null) ? prev.getValue() : null),
                    ((curr != null) ? curr.getValue() : null),
                    ((next != null) ? next.getValue() : null));
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev;

        System.out.printf("\nprev: %s curr: %s next: %s",
                ((prev != null) ? prev.getValue() : null),
                ((curr != null) ? curr.getValue() : null),
                ((next != null) ? next.getValue() : null));

    }
}
