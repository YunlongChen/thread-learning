package com.stan.threadlearning.threadcommunication;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ProducerAndConsumerThread extends Thread {


    public static void main(String[] args) {

        List<String> factory = new ArrayList<>();

        //消费者线程
        new Thread(() -> {
            while (true) {
                synchronized (factory) {
                    if (factory.size() == 0) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "消费者陷入等待！");
                            factory.wait();
                            System.out.println(Thread.currentThread().getName() + "消费者结束等待！");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String s = factory.get(0);
                    factory.remove(s);
                    System.out.println(Thread.currentThread().getName() + "：取出了:" + s);
                    System.out.println("还剩下:" + factory.size());
                    factory.notify();
                }
            }
        }, "consumer").start();

        //消费者线程
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (factory) {
                    String string = Thread.currentThread().getName() + System.currentTimeMillis();
                    factory.add(string);
                    factory.notify();
                }

            }
        }, "producer").start();

        //消费者线程
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronized (factory) {
                    String string = Thread.currentThread().getName() + System.currentTimeMillis();
                    factory.add(string);
                    factory.notify();
                }
            }
        }, "producer-2").start();
    }

}
