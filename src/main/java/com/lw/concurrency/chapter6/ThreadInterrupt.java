package com.lw.concurrency.chapter6;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("==>" + this.isInterrupted());
                }
            }
        };
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.isInterrupted());//判断t是否休眠 false
        t.interrupt();
        System.out.println(t.isInterrupted());//判断t是否休眠 true

    }
}
