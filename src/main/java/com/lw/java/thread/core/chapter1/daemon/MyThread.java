package com.lw.java.thread.core.chapter1.daemon;

public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            try {
                i++;
                System.out.println("threadName=" + Thread.currentThread().getName() + " i=" + (i));
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
