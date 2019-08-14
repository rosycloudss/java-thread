package com.lw.java.thread.core.chapter3.join_test;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.join(2_000);
    }
}
