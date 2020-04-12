package com.stan.threadlearning.volatiletest;

public class Service {

    volatile private static boolean isContinue = true;

    public void runService() {

        long startTime = System.currentTimeMillis();
        int count = 0;
        while (isContinue) {
        }

        System.out.println("成功停止了，总共耗时:" + (System.currentTimeMillis() - startTime));
    }

    public void stopService() {
        isContinue = false;
    }
}
