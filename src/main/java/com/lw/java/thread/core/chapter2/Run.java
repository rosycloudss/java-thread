package com.lw.java.thread.core.chapter2;

/**
 * 当发生异常时，锁自动释放
 * 同步不具备继承性
 * 子类中重写了父类中的同步方法，如果不加synchronized关键字，则重写的方法不是同步方法
 */
public class Run {

    public static void main(String[] args) {
//        final Service service = new Service();
//        Thread t = new Thread(() -> {
//            service.testMehtod("4545");
//        });
//        Thread t1 = new Thread(() -> {
//            service.testMehtod("454545");
//        });
//        try {
//            t.start();
//            Thread.sleep(200);
//            t1.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread thread = new Thread(() -> {
//            Son son = new Son();
//            son.operatISonMethod();
//        });
//        thread.start();

        Thread thread = new Thread(() -> {
            Service service = new Service();
            service.service1();
            service.service3();
        });
        thread.start();
    }

}
