package com.lw.java.thread.core.chapter3.wait_old;

public class ThreadSubtract extends Thread {
    private Subtrace r;

    public ThreadSubtract(Subtrace r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}
