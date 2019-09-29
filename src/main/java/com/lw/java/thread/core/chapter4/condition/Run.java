package com.lw.java.thread.core.chapter4.condition;

public class Run {
    public static void main(String[] args) throws InterruptedException {

        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        ThreadB b = new ThreadB(service);
        b.start();
        Thread.sleep(3_000);
        service.singnal('1');
        service.singnal('2');
    }
}
