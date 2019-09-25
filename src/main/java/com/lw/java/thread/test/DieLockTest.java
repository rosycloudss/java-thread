package com.lw.java.thread.test;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-25
 */
public class DieLockTest {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "获取 lock1对象锁");
                    try {
                        Thread.sleep(5000);
                        synchronized (lock2){
                            System.out.println(Thread.currentThread().getName() + "获取 lock2对象锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "获取 lock2对象锁");
                    try {
                        Thread.sleep(5000);
                        synchronized (lock1){
                            System.out.println(Thread.currentThread().getName() + "获取 lock1对象锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
