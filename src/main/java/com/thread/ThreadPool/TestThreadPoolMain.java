package com.thread.ThreadPool;


import com.thread.TestRunnable;

public class TestThreadPoolMain {

    public static void main(String[] args)  {
        TestRunnable testRunnable = new TestRunnable();
        Thread thread = new Thread(testRunnable);
        TestThreadPool.getThreadPool().execute(thread);
    }

}
