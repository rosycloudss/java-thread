package com.lw.java.thread.core.chapter2.lock_change;

/**
 * 主要对象不变，即使对象的属性被改变，运行的结果还是同步的
 * 如果在 synchronized(锁对象) 代码块中修改了锁对象，则可能导致其他线程与当前线程争抢的锁不一样，导致出现异步
 */
public class MyService {
    private String lock = "123";

    public void testMehtod() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                lock = new String("456");
                Thread.sleep(2_000);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
