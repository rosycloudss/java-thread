package com.lw.java.thread.test;

/**
 * @author liwei-4
 * @description:
 * @date 2019-10-08
 */
public class InterruptThreadTest {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("开始执行");
                    try {
//                        lock.wait();
                        Thread t2 = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (true){

                                }
                            }
                        });
                        t2.start();
                        t2.join();
                    } catch (InterruptedException e) {
                        System.out.println("出行异常：" + e);
                    }
                    System.out.println("执行结束");
                }
            }
        });

        t1.start();

        try {
            Thread.sleep(5000);
            t1.interrupt();
            synchronized (lock){
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
