package com.lw.java.thread.core.chapter2.static_synchronized;

public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service){
        this.service = service;
    }
    @Override
    public void run() {
        service.printB();
    }
}
