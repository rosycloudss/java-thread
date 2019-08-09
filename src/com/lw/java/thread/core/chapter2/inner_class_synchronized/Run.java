package com.lw.java.thread.core.chapter2.inner_class_synchronized;

/**
 * 内部类和外部类锁代表的锁并不相同，一个线程既可以持有内部类实例的锁 也可以持有外部类实例的锁
 */
public class Run {
    public static void main(String[] args) {
        final OutClass.InnerClass1 innerClass1 = new OutClass.InnerClass1();
        final OutClass.InnerClass2 innerClass2 = new OutClass.InnerClass2();
        final OutClass outClass = new OutClass();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass1.method1(innerClass2); //持有innerClass2的锁
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass1.method2();//持有innerClass1的锁
            }
        }, "T2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass2.method1(); //持有innerClass2 的锁
            }
        }, "T3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                outClass.method1(); //持有 outClass的锁
            }
        }, "T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
