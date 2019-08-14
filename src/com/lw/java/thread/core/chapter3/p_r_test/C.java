package com.lw.java.thread.core.chapter3.p_r_test;

import java.util.Objects;

public class C {

    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (Objects.equals(ValueObject.value, "")) {
                    lock.wait();
                }
                System.out.println("get的值是：" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

