Timer 
    schedule(TimerTask task,Date firstTime,long period) : 在指定的日期之后，按指定的间隔周期性地无限循环地执行某一任务，如果
        计划时间早于当前时间，则立即执行task任务。
    schedule(TimerTask task,long delay): 以当前时间为参考时间，在此时间的基础上延迟指定的毫秒数后执行一次TimerTask任务
    schedule(TimerTack task,long dely,long period): 以当前时间为参考时间，在此时间基础上延迟指定的毫秒数，再以某一间隔时间无限次数的执行某一任务
    cancel(): 将任务队列中的全部任务清空
TimerTask
    cancel(): 将自身从任务队列中清除
    
    