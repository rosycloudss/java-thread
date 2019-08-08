package com.lw.concurrency.chapter4;

/**
 * 守护线程：当一个线程停止后，这个线程的守护线程也会停止
 */
public class DaemonThread {

    public static void main(String[] args) {

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " running");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + " done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };//new
        t.setDaemon(true);
        //runnable -> running! ->dead! ->blocked
        t.start();
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
/**
 * A<------------------------------------------------------>B
 *
 *
 */
