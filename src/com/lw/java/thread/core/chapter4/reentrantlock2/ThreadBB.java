package com.lw.java.thread.core.chapter4.reentrantlock2;

public class ThreadBB extends Thread {
    private MyService service;

    public ThreadBB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}
