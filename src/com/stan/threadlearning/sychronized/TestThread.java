package com.stan.threadlearning.sychronized;

public class TestThread {
    public static void main(String[] args) {

//验证继承方法的同步性
//        MyObject object = new MySubObject();
//
//        TestSynchronizedThreadA threadA = new TestSynchronizedThreadA(object);
//        TestSynchronizedThreadB threadB = new TestSynchronizedThreadB(object);
//
//        threadA.start();
//        threadB.start();


        MyObject object = new MyObject();

        TestSynchronizedThreadA threadA = new TestSynchronizedThreadA(object);
        TestSynchronizedThreadB threadB = new TestSynchronizedThreadB(object);

        threadA.start();
        threadB.start();
    }
}
