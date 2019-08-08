package com.lw.java.thread.core.chapter1.susped_resume_test;

/**
 * suspend() 暂停线程
 * resume() 重启线程
 * suspend 和 resume方法的缺点----独占：
 *      在使用suspend和resume方法时，如果使用不当，极易造成公共的同步对象的独占，使得其他线程无法访问公共同步对象
 *      不同步：
 *      使用supend和resume方法时也容易出现因为线程的暂停而导致数据不同步的情况
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(5000);
            //A
            thread.suspend();//暂停线程
            System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(5000);
            System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());
            //B
            thread.resume();//
            Thread.sleep(5000);

            //C
            thread.suspend();
            System.out.println("C=" + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(5000);
            System.out.println("C=" + System.currentTimeMillis() + " i=" + thread.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
