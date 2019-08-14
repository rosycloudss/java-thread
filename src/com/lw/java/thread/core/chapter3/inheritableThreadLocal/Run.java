package com.lw.java.thread.core.chapter3.inheritableThreadLocal;

public class Run {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在main 线程中取值=" + Tools.t1.get());
                Thread.sleep(100);
            }
            ThreadA threadA = new ThreadA();
            threadA.start();
            ThreadB b = new ThreadB();
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
