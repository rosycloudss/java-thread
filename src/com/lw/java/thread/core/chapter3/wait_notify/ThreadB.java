package com.lw.java.thread.core.chapter3.wait_notify;

public class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                System.out.println(list.size());
                if (list.size() == 5) {
                    System.out.println("==5了，线程B 要退出了！");
                    throw new InterruptedException();//通过抛出异常结束线程
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
