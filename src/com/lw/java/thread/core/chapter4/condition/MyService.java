package com.lw.java.thread.core.chapter4.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMehtod() {
        try {
            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("锁释放了");
        }
    }

    public void singnal() {
        try {
            lock.lock();
            System.out.println("signal时间为" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
