package com.lw.java.thread.core.chapter2;

public class MyThread2 extends Thread{
    private MyOneList list;

    public MyThread2(MyOneList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(list,"B");
    }
}
