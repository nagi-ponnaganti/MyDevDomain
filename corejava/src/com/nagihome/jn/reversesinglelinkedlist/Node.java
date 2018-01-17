package com.nagihome.jn.reversesinglelinkedlist;

public class Node<T> implements Comparable<T> {

    private T value;
    private Node<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public int compareTo(T o) {
        if(o == this.value){
            return 0;
        } else {
            return 1;
        }

    }
}
