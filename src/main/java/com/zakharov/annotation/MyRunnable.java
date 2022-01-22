package com.zakharov.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeat(3)
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello");
    }
}



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Repeat {
    int value() default 1;
}
