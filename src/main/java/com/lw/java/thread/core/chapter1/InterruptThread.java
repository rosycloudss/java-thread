package com.lw.java.thread.core.chapter1;

/**
 * 停止线程：
 * 1.使用退出标志，使线程正常退出，也就是当run方法完成后线程终止
 * 2.使用stop方法强行终止线程，但是不推荐使用这个方法，因为stop和suspend及resume一样都是作废过期的方法，使用他们可能产生不可预料的结果
 *   使用stop方法强行终止线程可能导致一些清理性的工作无法完成，比如关闭数据库连接等
 * 3.使用interrupt方法中断线程
 * this.interrupted():测试当前线程是否中断 静态方法 线程的中断状态由该方法清除，如果连续两次调用该方法，则第二次将返回false(在第一次调用已清除了其中断状态)
 *                    是一个静态方法
 * this.isInterrupted():测试线程是否已经中断 不清除中断状态
 * <p>
 * 停止线程的方法：
 * 1.异常法  可以在循环中判断线程是否为停止状态如果为停止状态则抛出InterruptedException异常，并捕获 (建议使用)
 * 2.暴力停止 使用stop方法 如果强行让线程停止则可能使一些清理性的工作得不到完成，
 * 还有可能对锁定的对象进行了“解锁”，导致数据得不到同步的处理，出现数据不一致的问题
 * 3.使用return停止线程
 */
public class InterruptThread {
    public static void main(String[] args) {
//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 50000; i++) {
////                System.out.println("i=" + (i + 1));
//            }
//            Thread.currentThread().interrupt();
//            System.out.println("是否停止=" + Thread.interrupted());
//        });
        Thread thread = new MyThread1();

        try {
            thread.start();
//            thread.join();
            Thread.sleep(1);
            thread.interrupt();
            System.out.println("是否停止1？=" + thread.interrupted());
            System.out.println("是否停止2？=" + thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//并没有停止线程
    }

    /**
     *
     */
}
