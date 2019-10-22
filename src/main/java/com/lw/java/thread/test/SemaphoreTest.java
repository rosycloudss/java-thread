package com.lw.java.thread.test;

import com.lw.java.thread.core.chapter3.p_r_test.ThreadP;

import java.util.concurrent.Semaphore;

/**
 * @author liwei-4
 * @description:
 * @date 2019-10-08
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // 最多两个线程执行
        for (int i = 0; i < 4; i++) {
            final int time = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            semaphore.acquire(); // 获取许可
                            System.out.println(Thread.currentThread().getName() + "---" + time);
                            semaphore.release();// 归还许可
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
//        StringBuffer
    }
}
