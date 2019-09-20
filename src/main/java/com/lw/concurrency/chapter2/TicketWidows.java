package com.lw.concurrency.chapter2;

public class TicketWidows implements Runnable {

    private final int MAX = 50;//最大号数

    private int index = 1;//当前号数

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + "当前号数为：" + (index++));
        }
    }
}
