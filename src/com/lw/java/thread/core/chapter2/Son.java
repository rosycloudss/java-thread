package com.lw.java.thread.core.chapter2;

public class Son extends Father {
    synchronized public void operatISonMethod() {
        try {
            i--;
            System.out.println("son print i =" + i);
            Thread.sleep(100);
            this.operatIFaMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    synchronized public void operatIFaMethod() {
//        try {
//            i--;
//            System.out.println("son print i =" + i);
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
