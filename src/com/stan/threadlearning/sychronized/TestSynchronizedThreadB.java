package com.stan.threadlearning.sychronized;

public class TestSynchronizedThreadB extends Thread {


    private MyObject object;

    public TestSynchronizedThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        this.object.methodB();
    }
}
