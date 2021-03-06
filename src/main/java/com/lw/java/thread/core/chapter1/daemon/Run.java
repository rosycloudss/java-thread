package com.lw.java.thread.core.chapter1.daemon;

/**
 * 线程主要分为 1.用户线程  2.守护线程
 * 守护线程是一种特殊的线程，当进程中不存在非守护线程时，则守护线程自动销毁。
 * 注：当进程中还有非守护线程时，守护线程时不会自动销毁的。
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            MyThread thread1 = new MyThread();
            MyThread thread2 = new MyThread();
            thread.start();
            thread1.start();
            thread2.start();
            Thread.sleep(5000);
            thread1.interrupt();
            thread2.interrupt();
            System.out.println("结束执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
