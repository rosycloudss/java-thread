package com.lw.java.thread.core.chapter3.wait_old;

public class Subtrace {

    private String lock;

    public Subtrace(String lock) {
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
                }
            }
            ValueObject.list.remove(0);
            System.out.println("list size=" + ValueObject.list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
