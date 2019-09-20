package com.lw.java.thread.core.chapter3.wait_notify_insert_test;

public class DBTools {

    volatile private boolean preIsA = false;

    synchronized public void backupA() throws InterruptedException {
        while (preIsA) {
            wait();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("AAAAAA");
        }
        preIsA = true;
        notifyAll();
    }

    synchronized public void backupB() throws InterruptedException {
        while (!preIsA) {
            wait();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("BBBBBB");
        }
        preIsA = false;
        notifyAll();
    }

}
