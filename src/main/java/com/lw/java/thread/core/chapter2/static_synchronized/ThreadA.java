package com.lw.java.thread.core.chapter2.static_synchronized;

public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service){
        this.service = service;
    }
    @Override
    public void run() {
        service.printA();
    }
}
