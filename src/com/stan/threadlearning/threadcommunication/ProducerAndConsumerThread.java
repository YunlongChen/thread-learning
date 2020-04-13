package com.stan.threadlearning.threadcommunication;

import java.util.ArrayList;
import java.util.List;

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
        }, "consumer-1").start();

        //消费者线程
        new Thread(() -> {
            while (true) {
                synchronized (factory) {

                    if (factory.size() > 100) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "生产者1陷入等待！");
                            factory.wait();
                            System.out.println(Thread.currentThread().getName() + "生产者1结束等待！");
                            continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String string = Thread.currentThread().getName() + "-" + System.currentTimeMillis();
                    factory.add(string);
                    System.out.println(Thread.currentThread().getName() + "产生了" + string);
                    factory.notify();
                }
            }
        }, "producer-1").start();

        //消费者线程
        new Thread(() -> {
            while (true) {
                synchronized (factory) {
                    if (factory.size() > 100) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "生产者2陷入等待！");
                            factory.wait();
                            System.out.println(Thread.currentThread().getName() + "生产者2结束等待！");
                            continue;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String string = Thread.currentThread().getName() + "-" + System.currentTimeMillis();
                    factory.add(string);
                    System.out.println(Thread.currentThread().getName() + "产生了" + string);
                    factory.notify();
                }
            }
        }, "producer-2").start();
    }

}
