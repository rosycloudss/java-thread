package com.lw.java.thread.core.chapter2;

import com.lw.java.thread.core.chapter1.daemon.MyThread;

public class Run1 {
    public static void main(String[] args) {
        try {
            MyOneList list = new MyOneList();
            MyThread1 myThread1 = new MyThread1(list);
            myThread1.setName("A");
            myThread1.start();
            MyThread2 mythread2 = new MyThread2(list);
            mythread2.setName("B");
            mythread2.start();
            Thread.sleep(6000);
            System.out.println("listSize=" + list.getSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
