package com.lw.java.thread.core.chapter2.volatile_test;

import java.util.concurrent.atomic.AtomicInteger;

public class AddCountThread extends Thread {
    private AtomicInteger atomicCount = new AtomicInteger(0);

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            System.out.println("atomicCount=" + atomicCount.incrementAndGet());
            System.out.println("count=" + (count++));
        }
    }
}
