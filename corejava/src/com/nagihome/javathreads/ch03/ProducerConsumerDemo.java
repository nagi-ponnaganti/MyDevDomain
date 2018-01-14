package com.nagihome.javathreads.ch03;

public class ProducerConsumerDemo {

    public static void main(String[] args) {

        Shared shared = new Shared();

        new Thread(new Producer(shared)).start();
        new Thread(new Consumer(shared)).start();

    }

}

class Producer implements Runnable {

    public Producer(Shared shared) {
        this.shared = shared;
    }

    private final Shared shared;

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            shared.setSharedChar(ch);
            System.out.printf("%s is produced by producer\n", ch);
        }
    }
}


class Consumer implements Runnable {

    public Consumer(Shared shared) {
        this.shared = shared;
    }

    private final Shared shared;

    @Override
    public void run() {
        char ch;
        do {
            ch = shared.getSharedChar();
            System.out.printf("%s is consumed by consumer\n", ch);
        } while (ch != 'Z');
    }
}


class Shared {

    private char sharedChar;
    private volatile boolean isWritable = true;

    public synchronized void setSharedChar(char c) {

        while (!isWritable)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        this.sharedChar = c;
        isWritable = false;
        notify();
    }

    public synchronized char getSharedChar() {

        while (isWritable)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        isWritable = true;
        notify();

        return sharedChar;
    }

}
