package com.stan.threadlearning.priority;

import java.util.Random;

public class MyThread2 extends Thread {
    @Override
    public void run() {


//        System.out.println("Mythread Priority：" + this.getPriority());

        long startTime = System.currentTimeMillis();

        long result = 0;
        for (int i = 0; i < 1000; i++) {

            for (int j = 0; j < 100; j++) {
                Random random = new Random();
                int nextInt = random.nextInt();
                result += nextInt;
            }
        }
        long endtTime = System.currentTimeMillis();

        System.out.println("●●●●●●●●●●●：总共消耗时间：" + (endtTime - startTime) + "\tresult:" + result);

    }
}