package com.lw.java.thread.core.chapter2.volatile_test;

public class Run {
    public static void main(String[] args) {
//        PrintString printString = new PrintString();
//        new Thread(printString).start();
//        System.out.println("我要停止它！ stopThread=" + Thread.currentThread().getName());
//        printString.setContinuePrint(false); //运行在-server服务器模式中的64bit的jvm上时，会出现死循环

        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.start();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
        System.out.println("发出停止命令！");
    }
}
