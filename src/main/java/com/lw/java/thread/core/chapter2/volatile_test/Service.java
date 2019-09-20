package com.lw.java.thread.core.chapter2.volatile_test;

/**
 * 关键字synchronized可以保证在同一时刻，只有一个线程可以执行某一个方法或某一个代码块，它包含两个特征:互斥性和可见性
 * 同步synchronized不仅可以解决一个线程看到对象处于不一致的状态，还可以保证进入同步方法保证同步代码块的每个线程，都看到由同一个锁保护之前所有的修改效果
 * 同步就是将线程的并行执行变成串行执行
 */
public class Service {
    private boolean isContinueRun = true;

    public void runMethod() {
        String anyThing = new String();
        while (isContinueRun) {
            synchronized (anyThing) {

            }
        }
        System.out.println("停下来了！");
    }

    public void stopMethod() {
        isContinueRun = false;
    }
}
