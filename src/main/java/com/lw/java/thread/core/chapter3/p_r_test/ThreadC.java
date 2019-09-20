package com.lw.java.thread.core.chapter3.p_r_test;

import com.lw.java.thread.core.chapter3.wait_notify.ThreadA;

public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
