package com.lw.concurrency.chapter5;

import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });
        Thread t2 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });
        t1.start();
        t2.start();
        try {

//            t1.join();//等待这个线程死亡。 等待t1线程死亡后在运行当前线程的后续代码,join方法是相对于当前线程，即使当前线程等待这个线程执行结束后再运行
            t1.join(1_000);//等待t1死亡最多1000毫秒
//            t1.join(1_000,1_000);//等待t1最多 1000毫秒加上1000纳秒这个线程死亡
            t2.join();//等待t2线程死亡后在运行当前线程的后续代码 t1 和 t2 会交替运行，

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }

}
