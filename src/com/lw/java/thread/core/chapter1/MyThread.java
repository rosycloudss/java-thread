package com.lw.java.thread.core.chapter1;

public class MyThread extends Thread {

    private int count = 5;

    /**
     * 当一个线程想要执行同步方法中的代码时，线程首先尝试去拿这把锁，如果能够拿到这把锁，那么这个线程就可以执行synchronized里面的代码，
     * 如果不能难道这把锁，那么这个线程就会不断尝试拿这把锁
     *
     * ”非线程安全“ 主要是指多个线程对同一个对象中 的同一个实例变量进行操作时会出现值被更改，值不同步的情况，进而影响程序的执行流程。
     *
     * println() 方法和i++联合使用时“有可能"出现异常情况
     *
     * currentThread() 方法返回代码正在被哪个线程调用的信息
     *
     * isAlive() 方法判断当前的线程是否处于活动状态（线程已经启动且尚未终止）
     * sleep() 方法的作用是在指定的毫秒数内让当前“正在执行的线程”休眠（暂停执行）这个“正在执行的线程”是指this.currentThread()返回的线程，
     *          即调用当前代码的线程
     * getId()  方法的作用是取得线程的唯一标识
     *停止线程： 1.使用退出标志，使线程正常退出，也就是当run方法完成后线程终止
     *          2.使用stop方法强行终止线程，但是不推荐使用这个方法，因为stop和suspend及resume一样都是作废过期的方法，使用他们可能产生不可预料的结果
     *          3.使用interrupt方法中断线程
     *线程的优先级：
     *
     *
     */
    @Override
    synchronized public void run() {
        super.run();
        count--;//分三步执行 1.先取count的值 2.将count的值减一 3.对count进行赋值
        System.out.println("threadName=" +Thread.currentThread().getName() + " count=" + count);
    }
}
