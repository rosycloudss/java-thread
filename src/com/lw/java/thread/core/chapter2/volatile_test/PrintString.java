package com.lw.java.thread.core.chapter2.volatile_test;

/**
 * 在jvm 被设置成-server模式时，为了线程运行的效率，线程一直在私有堆栈中取得变量值
 * volatile 的作用是 当线程访问 该关键字修饰的变量时，强制性从公共堆栈中进行取值
 */
public class PrintString implements Runnable {
     volatile private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void pringStringMethod() {
        try {
            while (isContinuePrint) {
                System.out.println("run printStringMethod threadName=" + Thread.currentThread().getName());
                Thread.sleep(1_000);
            }
            System.out.println(isContinuePrint);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        pringStringMethod();
    }
}
