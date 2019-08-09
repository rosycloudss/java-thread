package com.lw.java.thread.core.chapter1.yield_test;

/**
 * yield() 方法：放弃当前所占有的cpu资源，让其他线程去使用
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            Thread.yield();//放弃当前的cpu资源，将它让给其他的任务去占用cpu执行时间
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + " 毫秒");
    }
}
