package com.thread.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    private final static ThreadPoolExecutor threadPool ;
    private static int corePoolSize=20;
    private static int maximumPoolSize=200;
    private static int workQueue=200;


    static {
        threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(workQueue),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }

}
