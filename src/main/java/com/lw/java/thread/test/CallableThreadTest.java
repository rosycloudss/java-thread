package com.lw.java.thread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-24
 */
public class CallableThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Object> ft = new FutureTask<Object>(new ThreadCallable());
        Thread t = new Thread(ft);
        t.start();
        System.out.println(ft.get()); // 等到ft执行完毕然后返回值

//    ReentrantReadWriteLock reentrantReadWriteLock = null;
//    reentrantReadWriteLock.readLock();
//    reentrantReadWriteLock.writeLock();
    }


}

class ThreadCallable implements Callable {
    @Override
    public Object call() throws Exception {
       for (int i = 0;i < 10;i++){
           System.out.println("test");
           Thread.sleep(1000);
       }
        return this;
    }
}
