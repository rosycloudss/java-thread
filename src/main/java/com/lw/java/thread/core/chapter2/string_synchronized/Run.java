package com.lw.java.thread.core.chapter2.string_synchronized;

/**
 * 当synchronized(常量字符串) 时 所用使用相同字符串作为锁的代码块同步
 * 但如果字符串是一个对象时 如 new String("AA") 则不同步
 */
public class Run {
    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            Service.print("AA");
//        });
        Thread t1 = new Thread(() -> {
            Service.print(new String("AA"));
        });
        t1.setName("A");
        t1.start();

//        Thread t2 = new Thread(() -> {
//            Service.print("AA");
//        });
        Thread t2 = new Thread(() -> {
            Service.print(new String("AA"));
        });
        t2.setName("B");
        t2.start();
    }
}
