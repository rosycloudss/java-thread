package com.lw.concurrency.chapter2;

/**
 * @ClassName:Bank
 * @Author:liwei
 * @Description: TODO
 * @Date:2019/7/8 10:29
 * @Version: V1.0
 */
public class Bank {

    public static void main(String[] args) {

        Runnable runnable = new TicketWidows();


        Thread tickeWindows1 = new Thread(runnable, "一号窗口");
        Thread tickeWindows2 = new Thread(runnable, "二号窗口");
        Thread tickeWindows3 = new Thread(runnable, "三号窗口");

        tickeWindows1.start();
        tickeWindows2.start();
        tickeWindows3.start();

    }
}
