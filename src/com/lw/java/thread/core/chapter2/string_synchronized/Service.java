package com.lw.java.thread.core.chapter2.string_synchronized;

import com.lw.java.thread.core.chapter2.static_synchronized.ThreadC;

public class Service {

    public static void print(String stringParam) {
        try {
            synchronized (stringParam) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1_000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
