package com.lw.java.thread.core.chapter1.priority;

import java.util.Random;

public class MyThread2 extends Thread {
    @Override
    public void run() {

        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + 1;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thread2 执行时间:" + (endTime - beginTime) + " 毫秒");
    }
}
