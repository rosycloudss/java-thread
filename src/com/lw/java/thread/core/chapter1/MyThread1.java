package com.lw.java.thread.core.chapter1;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5000000; i++) {
//            try {
//                Thread.sleep(100000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if(!this.isInterrupted()) {
              System.out.println("i=" + (i + 1));
          }else {
              System.out.println("线程已被停止");
              break;
          }
        }
    }
}
