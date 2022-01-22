package com.zakharov.annotation;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        if (command.getClass().getAnnotation(Repeat.class)==null)
        {
            super.execute(command);
        } else
            for (int i = 0; i < command.getClass().getAnnotation(Repeat.class).value();i++) {
                super.execute(command);
            }
    }
}
