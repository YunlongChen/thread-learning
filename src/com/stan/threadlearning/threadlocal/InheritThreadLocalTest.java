package com.stan.threadlearning.threadlocal;

import java.util.Date;
import java.util.stream.IntStream;

public class InheritThreadLocalTest extends InheritableThreadLocal<String> {

    @Override
    protected String initialValue() {
        return new Date().toString();
    }

    @Override
    protected String childValue(String parentValue) {

        return parentValue + ":这是在子线程" + Thread.currentThread().getName() + "加上的";
    }

    public static void main(String[] args) {


        InheritThreadLocalTest inheritThreadLocalTest = new InheritThreadLocalTest();

        IntStream.range(0, 5).forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("在主线程中获得的值是：" + Thread.currentThread().getName() + ":" + inheritThreadLocalTest.get());
        });
        new Thread(() -> {

            new Thread(() -> {
                IntStream.range(0, 5).forEach(i -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("在子线程中获得的值是：" + Thread.currentThread().getName() + ":" + inheritThreadLocalTest.get());
                });
            }).start();


            IntStream.range(0, 5).forEach(i -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("在子线程中获得的值是：" + Thread.currentThread().getName() + ":" + inheritThreadLocalTest.get());
            });
        }).start();


    }
}
