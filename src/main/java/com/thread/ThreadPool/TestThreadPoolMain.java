package com.thread.ThreadPool;


import com.thread.TestRunnable;

import java.util.concurrent.Executors;


public class TestThreadPoolMain {

    public static void main(String[] args)  {
        TestRunnable testRunnable = new TestRunnable();
        Thread thread = new Thread(testRunnable);
        TestThreadPool.getThreadPool().execute(thread);

        Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
        Executors.newFixedThreadPool(3);    //创建固定容量大小的缓冲池,可控制线程最大并发数，超出的线程会在队列中等待
        Executors.newScheduledThreadPool(3);//创建一个定长线程池，支持定时及周期性任务执行

    }

}
