package com.stan.threadlearning.join;

public class JoinTestThread {

    public static void main(String[] args) {

        //开始执行线程
        System.out.println(Thread.currentThread().getName() + "：开始执行线程");
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "：开始执行任务:" + 1000 + "ms");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：任务执行完毕:");
        });
        thread.start();
        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("这个结果应该是在上面那个线程之后才会输出来的");
    }

}
