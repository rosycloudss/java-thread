package com.lw.java.thread.core.chapter3.inheritableThreadLocal;

public class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在ThreadA 线程中取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
            ThreadB b = new ThreadB();
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
