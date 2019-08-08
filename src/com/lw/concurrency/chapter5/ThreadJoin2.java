package com.lw.concurrency.chapter5;

import javax.swing.plaf.TableHeaderUI;
import java.sql.SQLOutput;

public class ThreadJoin2 {
    public static void main(String[] args) {
        long startTimeStamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 15000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 30000L));
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTimeStamp = System.currentTimeMillis();

        System.out.printf("Save data begin timestamp is :%s ,end timestamp is:%s\n",startTimeStamp,endTimeStamp);
    }
}

class CaptureRunnable implements Runnable {
    private String machineName;

    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        //do the really capture data;
        try {
            Thread.sleep(spendTime);
            System.out.printf(machineName + " completed data capture at timestamp [%s] and sucess.\n",System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getResult() {
        return machineName + " finish.";
    }
}
