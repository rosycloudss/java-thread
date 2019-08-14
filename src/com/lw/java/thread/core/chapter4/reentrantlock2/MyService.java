package com.lw.java.thread.core.chapter4.reentrantlock2;

import com.lw.java.thread.core.chapter3.wait_old.ThreadAdd;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("mehtodA begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("mehtodA end ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println("mehtodB begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("mehtodB end ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
