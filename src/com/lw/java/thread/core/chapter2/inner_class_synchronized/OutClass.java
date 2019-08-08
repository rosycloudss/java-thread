package com.lw.java.thread.core.chapter2.inner_class_synchronized;

public class OutClass {
    static class InnerClass1 {
        public void method1(InnerClass2 class2) {
            String threadName = Thread.currentThread().getName();
            synchronized (class2) {
                System.out.println(threadName + " 进入InnerClass1类中的method1方法");
                for (int i = 0; i < 10; i++) {
                    System.out.println("i=" + i);
                    try {
                        Thread.sleep(1_00);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + " 离开InnerClass1类中的method1方法");
            }
        }

        public synchronized void method2() {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " 进入InnerClass1类中的method2方法");
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
                try {
                    Thread.sleep(1_00);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " 离开InnerClass1类中的method2方法");

        }
    }

    static class InnerClass2 {
        public synchronized void method1() {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + " 进入InnerClass2类中的method1方法");
            for (int k = 0; k < 10; k++) {
                System.out.println("k=" + k);
                try {
                    Thread.sleep(1_00);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " 离开InnerClass2类中的method1方法");

        }
    }

    public synchronized void method1() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " 进入OutClass类中的method1方法");
        for (int n = 0; n < 10; n++) {
            System.out.println("k=" + n);
            try {
                Thread.sleep(1_00);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " 离开OutClass类中的method1方法");

    }
}
