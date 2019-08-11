package com.lw.java.thread.core.chapter3.wait_notify1;


public class Run {
    public static void main(String[] args) {
        try {
            MyList service = new MyList();
            ThreadA a = new ThreadA(service);
            a.setName("A");
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(service);
            b.setName("B");
            b.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
