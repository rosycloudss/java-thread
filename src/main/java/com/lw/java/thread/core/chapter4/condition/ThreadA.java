package com.lw.java.thread.core.chapter4.condition;

public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMehtod('1');
    }
}
