package com.lw.java.thread.core.chapter5.timertest1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {

    private static Timer timer = new Timer(true);

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！ 时间为：" + new Date());
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2019-08-16 10:42:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符串时间：" + dateRef.toLocaleString() + " 当前时间：" + new Date().toLocaleString() );
        /**
         * 如果执行任务的时间早于当前时间，则立即执行task任务
         * 一个 timer 中可以运行多个TimerTask任务
         * TimerTask 是以队列的方式一个一个被顺序执行的，所以执行的时间有可能和预期的时间不一致，因为前面的任务有可能消耗的时间
         * 较长，则后面的任务运行的时间也会被延迟
         *
         */
        timer.schedule(task,dateRef);
    }
}
