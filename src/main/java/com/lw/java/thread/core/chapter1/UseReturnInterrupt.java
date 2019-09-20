package com.lw.java.thread.core.chapter1;

public class UseReturnInterrupt {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("停止了！");
                    return;
                }
                System.out.println("timer=" + System.currentTimeMillis());
            }
        });
        try {
            t.start();
            Thread.sleep(2000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}