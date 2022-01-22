package com.zakharov.annotation;


import java.util.concurrent.*;


public class ExtraTask {
    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor = new
                CustomThreadPoolExecutor(1, 2, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        customThreadPoolExecutor.execute(new MyRunnable());
        customThreadPoolExecutor.shutdown();

    }
}


