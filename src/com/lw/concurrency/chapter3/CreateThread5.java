package com.lw.concurrency.chapter3;

/**
 * 1.创建线程对象Thread，默认有一个线程名，以Thread-开头，从0开始计数
 * 2.如果在构造Thread的时候没有传递Runnable 或者没有复写Thread 的run方法，该Thread将不会调用任何东西，如果传递了Runnable接口的实例，或者复写了Thread的run方法，则会执行该
 * 方法的逻辑单元（逻辑代码）。
 * 3.如果构造线程对象时未传入ThreadGroup，Thread会默认获取父线程的ThreadGroup作为该线程的ThreadGroup，此时子线程和父线程将会在同一个ThreadGroup中
 * 4.构造Thread的时候传入stacksize代表着该线程占用的statck大小，如果没有指定statcksize的大小，默认是0,0代表着会忽略该参数，该参数会被JNI函数去使用，需要注意：该参数有一些平台有效，
 * 在有些平台无效
 */
public class CreateThread5 {

    private static int counter = 1;

    public static void main(String[] args) {

        try {
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                counter++;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] data = new byte[1024 * 1024 * 2];
//                        try {
//                            Thread.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }).start();
            }
        } catch (Error e) {
            e.printStackTrace();
        }
        System.out.println("Total created thread nums =>" + counter);
    }
}
