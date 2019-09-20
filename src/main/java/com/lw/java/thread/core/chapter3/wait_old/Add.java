package com.lw.java.thread.core.chapter3.wait_old;



public class Add {

    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add(){
        synchronized (lock){
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
