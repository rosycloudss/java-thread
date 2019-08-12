package com.lw.java.thread.core.chapter3.wait_old;

import com.lw.java.thread.core.chapter3.wait_notify.ThreadA;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtrace subtrace = new Subtrace(lock);
        ThreadSubtract subtract1Thread = new ThreadSubtract(subtrace);
        subtract1Thread.setName("subtract1Thread");
        subtract1Thread.start();

        ThreadSubtract subtract2Thread = new ThreadSubtract(subtrace);
        subtract2Thread.setName("subtract2Thread");
        subtract2Thread.start();

        Thread.sleep(1000);
        ThreadAdd addThread = new ThreadAdd(add);
        addThread.setName("addThread");
        addThread.start();
    }
}
