package com.stan.threadlearning.mythread;

public class MyThread extends Thread {

    private long i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.suspend();
            System.out.println("main end");
        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }
    }
}
