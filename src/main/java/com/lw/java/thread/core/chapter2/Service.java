package com.lw.java.thread.core.chapter2;

public class Service {

    synchronized public void service1() {
        System.out.println("service1");
        service2();//调用service2方法
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }

    synchronized public void testMehtod(String numStr) {
        System.out.println("threadName=" + Thread.currentThread().getName() + " start");
        long startTime = System.currentTimeMillis();
        int num = Integer.parseInt(numStr);
        try {
            Thread.sleep(1_000);
            long endTime = System.currentTimeMillis();
            System.out.println("num=" + num + " startTime=" + startTime + " endTime=" + endTime + " threadName=" + Thread.currentThread().getName());
            System.out.println("threadName=" + Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
