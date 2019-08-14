package com.lw.java.thread.core.chapter3.p_r_test;

import com.lw.java.thread.core.chapter3.wait_notify.ThreadA;

public class Run {
    public static void main(String[] args) {
        String lock = new String("lock");
//        Thread cThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                C c = new C(lock);
//                while (true) {
//                    c.getValue();
//                }
//            }
//        });
//        cThread.start();
//
//        Thread pThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                P p = new P(lock);
//                while (true) {
//                    p.setValue();
//                }
//            }
//        });
//        pThread.start();

        C c = new C(lock);
        P p = new P(lock);
        for (int i = 0; i < 2; i++) {
            new ThreadC(c).start();
            new ThreadP(p).start();
        }


    }
}
