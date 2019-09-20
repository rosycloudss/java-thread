package com.lw.java.thread.core.chapter2.static_synchronized;

/**
 * 静态同步synchronized方法和synchronized(class)代码块
 * 如果synchronize应用在static静态方法上，则对当前.java文件对应的class类进行持锁
 * 对象锁和class锁不相同：一个线程持有一个类的对象锁还可以持有这个类的class锁
 * Class锁对类的所有对象实例起作用
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        Service service1 = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(service1);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(service);
        threadC.setName("C");
        threadC.start();
    }
}
