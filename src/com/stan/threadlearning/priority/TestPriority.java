package com.stan.threadlearning.priority;

public class TestPriority {


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            MyThread1 myThread1 = new MyThread1();
            myThread1.setPriority(Thread.MAX_PRIORITY);
            //设置线程优先级为最大优先级
            myThread1.start();

            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(Thread.MIN_PRIORITY);
            thread2.start();
        }
    }
}
