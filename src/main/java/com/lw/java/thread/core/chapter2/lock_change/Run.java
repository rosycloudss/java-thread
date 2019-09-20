package com.lw.java.thread.core.chapter2.lock_change;

public class Run {

    public static void main(String[] args) {
        final MyService service = new MyService();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMehtod();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMehtod();
            }
        }, "t2");
        t1.start();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
