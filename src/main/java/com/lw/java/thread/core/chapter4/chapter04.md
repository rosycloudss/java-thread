ReentrantLock 类
    ReentranLock 类可以实现线程之间同步互斥，还具有嗅探锁定、多路分支通知等功能。
    
Condition: 
         ReentrantLock 也可以实现等待/通知模式，需要借助Condition对象
         Lock对象中可以创建多个Condition(对象监视器)实例，线程对象可以注册在指定的Condition中，从而有选择性地进行线程通知，在调度线程上更加灵活
         synchronized就相当于整个Lock对象中只有一个单一的Condition对象，所有的线程都注册在它一个对象上。
         Object 类中的wait()方法相当于Condition类中的await()方法
         Object类中的wait(long timeout)方法相当于Condition类中的await(long time,TimeUnit unit)方法
         Object 类中的notify()方法相当于Condition类中的signal()方法
         Object 类中的notifyAll()方法相当于Condition类中的signalAll()方法
           
公平锁和非公平锁
    锁lock分为“公平锁” 和 “非公平锁”
    公平锁：表示线程获取锁的顺序是按照线程加锁的顺序来分配的，即先到先得的FIFO先进先出顺序
    非公平锁：是一种获取锁的抢占机制，是随机获得锁的，和公平锁不一样的就是先来的不一定先得到锁。可能造成某些线程一直拿不到锁

int getHoldCount()：查询当前线程保持此锁定的个数，即调用lock() 方法的次数
int getQueueLength()：返回正等待获取此锁定的线程估计数，比如有5个线程，1个线程首先执行lock()方法，那么在调用getQueueLength() 方法后返回值是4，说明有4个线程同时在等待lock的释放
int getWaitQueueLength(Condition condition)：返回等待与此锁定相关的给定条件Condition的线程估计数；比如有5个线程，每个线程都执行了同一个condition对象的await()方法，
    则调用getWaitQueueLength(Condition condition)方法返回的int值是5，即返回等待 condition.signal() 唤醒的线程的数量
boolean hasQueuedThread(Thread thread): 查询指定的线程是否正在等待获取此锁定
boolean hasQueuedThreads(): 查询是否有线程正在等待获取此锁定
boolean hasWaiters(Condition condition): 查询是否有线程正在等待与此锁定有关的condition条件

boolean isFair(): 判断是不是公平锁
boolean isHeldByCurrentThread()：查询当前线程是否保持此锁定
boolean isLocked(): 查询此锁定是否由任意线程保持
void lockInterruptibly(): 如果当前线程未被中断，则获取锁定，如果已经被中断则抛出异常    lock():无论是否中断都获取锁定，
boolean tryLock()： 仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定
boolean tryLock(long timeout,TimeUnit unit):如果锁定在给定等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁定。
condition.awaitUninterruptibly(): 使当前线程等待，当发生中断时不产生异常

awaitUntil(long)：说明在等待时间到达前，可以被其他线程提前唤醒


ReentrantReadWriteLock 类： 读写锁  相对于 ReentrantLock 提高了效率
    共享锁 lock.readLock().lock()；排他锁 lock.writeLock().lock();
    多个读锁之间不互斥
    读锁与写锁互斥
    写锁与写锁互斥
    
