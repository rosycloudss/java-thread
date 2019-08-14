package com.lw.java.thread.core.chapter4.condition;

public class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMehtod();
    }
}
