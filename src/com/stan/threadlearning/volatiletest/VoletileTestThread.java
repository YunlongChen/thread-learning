package com.stan.threadlearning.volatiletest;

/**
 * 测试voletile关键字
 */
public class VoletileTestThread extends Thread {

    volatile private static int anInt = 0;

    public static void addCount() {

//        原子类也并不完全安全
//        因为虽然在对元子类的操作是具有原子性的，但是外面的逻辑却没有原子性
//        解决的办法就是使用synchronized来保证同步操作
        for (int i = 0; i < 100; i++) {
            anInt += 1;
        }
        System.out.println(anInt);

//        如果我们要在这里要求整个操作必须从零开始加到10000000并且顺序的显示的话，就必须要使用synchronized进行同步操作了
//        System.out.println(atomicInteger.get());
    }

    synchronized public static void addCountWithConsiquence() {

//        原子类也并不完全安全
//        因为虽然在对元子类的操作是具有原子性的，但是外面的逻辑却没有原子性
//        解决的办法就是使用synchronized来保证同步操作
        for (int i = 0; i < 1000; i++) {
            anInt += 1;
            System.out.println(anInt);
        }
        System.out.println(anInt);
//        如果我们要在这里要求整个操作必须从零开始加到10000000并且顺序的显示的话，就必须要使用synchronized进行同步操作了

    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {


        VoletileTestThread[] threadGList = new VoletileTestThread[100];

        for (VoletileTestThread thread : threadGList) {

            thread = new VoletileTestThread();
            thread.start();
        }
    }
}
