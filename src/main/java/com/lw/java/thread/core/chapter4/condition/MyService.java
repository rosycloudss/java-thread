package com.lw.java.thread.core.chapter4.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private volatile boolean runA = false;

    public void waitMehtod(char c) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ":A" + c);
            if (c == '1') {
                conditionA.await();
            } else {
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + ":B" + c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("锁释放了");
        }
    }

    public void singnal(char c) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "signal时间为" + System.currentTimeMillis() + c);
            if (c == '1') {
                conditionA.signal();
            } else {
                conditionB.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
