package com.stan.threadlearning.sychronized;

public class MyObject {
    private Integer valueLocker = 0;
    protected Integer value = 0;

    public void methodA() throws Exception {
        try {

            //synchronized 是可重入锁，在继承关系中，子类可以调用父类的所对象
            //这里的method的B是对象内部的同步方法
//            methodB();
            //当方法内部产生异常的时候，对象对自动释放锁

            System.out.println("this is methodA");
//            Thread.sleep(3000);
//            System.out.println("this is methodA2");
            System.out.println("开始运行A方法，调用线程：" + Thread.currentThread().getName());
            synchronized (valueLocker) {
                value = 1;
                Thread.sleep(3000);
                System.out.println(System.currentTimeMillis());
//            throw new Exception("methodA在执行过程中发生了异常");

                System.out.println("endA endTime:" + System.currentTimeMillis());
                System.out.println("value shoud be 1,acturally:" + value);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {

        System.out.println("this is methodB；" + System.currentTimeMillis());
        System.out.println("开始运行B方法,调用线程：" + Thread.currentThread().getName());

        synchronized (valueLocker) {
            value = 2;
        }
        System.out.println("endB endTime:" + System.currentTimeMillis());
        System.out.println(value);
    }
}
