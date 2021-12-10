package hw_1;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;
import java.util.concurrent.*;


public class ExtraTask {
    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor = new
                CustomThreadPoolExecutor(1, 2, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        customThreadPoolExecutor.execute(new MyRunnable());
        customThreadPoolExecutor.shutdown();

    }
}

@Repeat(3)
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello");
    }
}

class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        for (int i = 0; i < command.getClass().getAnnotation(Repeat.class).value();i++) {
            super.execute(command);
        }
    }
}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Repeat {
        int value() default 1;
    }
