package com.lw.java.thread.core.chapter3.wait_notify_insert_test;

import com.lw.java.thread.core.chapter3.p_r_test.ThreadP;

public class Run {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();

        for (int i = 0;i < 20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        dbTools.backupA();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        dbTools.backupB();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
