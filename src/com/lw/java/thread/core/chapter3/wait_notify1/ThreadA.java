package com.lw.java.thread.core.chapter3.wait_notify1;

public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.printf("wait begin " + System.currentTimeMillis());
                    lock.wait(); //暂停A线程，使其处于wait状态
                    System.out.printf("wait end " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
