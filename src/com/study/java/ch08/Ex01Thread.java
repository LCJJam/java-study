package com.study.java.ch08;

import static com.study.java.ch08.Ex01Thread.threadSleep;

public class Ex01Thread {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Market m = new Market();
        ProducerThread pt = new ProducerThread(m);
        ConsumerThread ct = new ConsumerThread(m);

        pt.start();
        ct.start();

        try {
            pt.join();
            ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%nResult: " + m.getCount_product());
    }

    static void threadSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Market {
    private int count_product = 0;
    final private int MAX = 3;
    final private int MIN = 0;

    synchronized public void add() {
        System.out.print("[추가전" + count_product + "]");
        while (count_product >= MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count_product++;
        notifyAll();
        System.out.println("[추가후" + count_product + "]");
    }

    synchronized public void remove() {
        System.out.print("[삭제전" + count_product + "]");
        while (count_product <= MIN) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count_product--;
        notifyAll();
        System.out.println("[삭제후" + count_product + "]");

    }

    synchronized public int getCount_product() {
        return count_product;
    }
}

class ProducerThread extends Thread {
    Market m;

    public ProducerThread(Market m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            threadSleep((int)(Math.random()*100));
            m.add();
        }
    }
}

class ConsumerThread extends Thread {
    Market m;

    public ConsumerThread(Market m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            threadSleep((int) (Math.random() * 1000));
            m.remove();
        }
    }
}
