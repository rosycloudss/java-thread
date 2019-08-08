package com.lw.java.thread.core.chapter2.inner_class_synchronized;

public class Run {
    public static void main(String[] args) {
        final OutClass.InnerClass1 innerClass1 = new OutClass.InnerClass1();
        final OutClass.InnerClass2 innerClass2 = new OutClass.InnerClass2();
        final OutClass outClass = new OutClass();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass1.method1(innerClass2);
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass1.method2();
            }
        }, "T2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass2.method1();
            }
        }, "T3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                outClass.method1();
            }
        }, "T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
