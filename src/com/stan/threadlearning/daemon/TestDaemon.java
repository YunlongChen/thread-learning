package com.stan.threadlearning.daemon;

public class TestDaemon {

    public static void main(String[] args) {


        System.out.println("我要开始工作了，需要有个人来帮我看着点\n麻烦一下蕾姆吧！");

        DaemonThread daemonThread = new DaemonThread();

        daemonThread.setDaemon(true);

        daemonThread.setName("蕾姆");
        daemonThread.start();

        System.out.println("Subaru，" + daemonThread.getName() + "来了！");

        try {
            System.out.println("工作非常辛苦，需要五十个小时才能完成，蕾姆，麻烦你了！");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("我工作完成了，蕾姆，你也可以休息了！");
    }
}
