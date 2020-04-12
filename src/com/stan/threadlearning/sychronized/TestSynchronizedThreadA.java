package com.stan.threadlearning.sychronized;

public class TestSynchronizedThreadA extends Thread {


    private MyObject object;


    public TestSynchronizedThreadA(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            this.object.methodA();
        } catch (Exception e) {
            System.out.println("执行methodA发生了异常：" + System.currentTimeMillis());
            e.printStackTrace();
        }
    }
}
