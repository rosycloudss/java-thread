package com.lw.java.thread.core.chapter3.wait_notify1;

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                MyList.add();
                if (MyList.size() == 5) {
                    lock.notify(); //通知A线程继续执行
                    System.out.println("已发出通知！");
                }
                System.out.println("添加了 " + (i + 1) + "个元素");
            }
        }
    }
}
