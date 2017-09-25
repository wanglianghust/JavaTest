package com.thread.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    private final static ThreadPoolExecutor threadPool ;
    private static int corePoolSize=20;//初始化线程大小
    private static int maximumPoolSize=200;//最大化线程大小
    private static int workQueue=200;//最大缓存队列大小


    static {
        threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(workQueue),
                //ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
                //ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
                //ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
                //ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
