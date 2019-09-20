package com.lw.java.thread.test;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutorServiceShutdown {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("time=" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName() + " interrupted=" + Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted() ){
                        try {
                            throw new InterruptedException("关闭线程异常");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("关闭线程" + Thread.currentThread().getName());

                    }
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("time1=" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName() + " interrupted=" + Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted() ){
                        System.out.println("关闭线程" + Thread.currentThread().getName());
                        break;
                    }
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("time2=" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName() + " interrupted=" + Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted() ){
                        System.out.println("关闭线程" + Thread.currentThread().getName());
                        break;
                    }
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("time3=" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName() + " interrupted=" + Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted() ){
                        break;
                    }
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("time4=" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName() + " interrupted=" + Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted() ){
                        System.out.println("关闭线程" + Thread.currentThread().getName());
                        break;
                    }
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("time5=" + System.currentTimeMillis() + "ThreadName=" + Thread.currentThread().getName() + " interrupted=" + Thread.currentThread().isInterrupted());
                    if (Thread.currentThread().isInterrupted() ){
                        System.out.println("关闭线程" + Thread.currentThread().getName());
                        break;
                    }
                }
            }
        });
        Thread.sleep(10000);
        executor.shutdownNow();
        Thread.sleep(10000);
//        if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
//            System.out.println("Still waiting...");
//            System.exit(0);
//        }
        executor = null;


        System.out.println("Exiting normally...");
//        executor = Executors.newSingleThreadExecutor();
//        executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println("time1=" + System.currentTimeMillis());
//                    if (Thread.currentThread().isInterrupted()) break;
//                }
//            }
//        });
    }
}
