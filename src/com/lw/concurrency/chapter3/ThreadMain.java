package com.lw.concurrency.chapter3;

/**
 * @ClassName:ThreadMain
 * @Author:liwei
 * @Description: TODO 
 * @Date:2019/7/8 10:38
 * @Version: V1.0
 *
 */
public class ThreadMain {
    
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println(t.getThreadGroup().getName());
        System.out.println(t.getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        t.start();
        ThreadGroup threadGroup = t.getThreadGroup();

        Thread[] threads= new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(Thread temp:threads){
            System.out.println(temp);
        }

        System.out.println();
    }
}
