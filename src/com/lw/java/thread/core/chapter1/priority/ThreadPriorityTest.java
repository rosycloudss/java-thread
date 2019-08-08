package com.lw.java.thread.core.chapter1.priority;

/**
 * 线程具有优先级
 * 线程中的优先级分为1~10这10个等级，如果小于1 大于10 则抛出IllegalArgumentException
 * 1.线程优先级具有继承特性：A线程创建B线程，则B线程的优先级和A线程的优先级相同
 * 2.优先级具有规则性：优先级高的线程一般先执行完，但是并不一定是优先级高的线程先执行完
 * 3.优先级具有随机性 优先级高的线程不一定每一次都先执行完
 */
public class ThreadPriorityTest {
    public static void main(String[] args) {
        for (int i = 1; i< 5;i++){
            MyThread myThread  = new MyThread();
            myThread.setPriority(10);
            myThread.start();
            MyThread2 myThread2  = new MyThread2();
            myThread2.setPriority(1);
            myThread2.start();
        }
    }
}
