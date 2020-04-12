package com.stan.threadlearning.threadcommunication;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现线程间通信wait/notify
 */
public class CommunicationThread extends Thread {

    private final List<String> list;
    private final static Object consumerLock = new Object();

    public CommunicationThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            try {
                System.out.println("wait 开始！" + System.currentTimeMillis());
                list.wait();
                System.out.println(Thread.currentThread().getName() + ":总共有" + list.size() + "，我就不先拿走了,辛苦你们了！:");
                Thread.sleep(1000);
                System.out.println("wai结束" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<String>();
        //通过集成Thread类实现多线程
        //注意到在使用lambda表达式不能带入参数，但是可以使用当前上下文中的变量
        CommunicationThread mainThread = new CommunicationThread(list);

        mainThread.setPriority(Thread.MAX_PRIORITY);
        mainThread.start();

        Thread.sleep(10);
        //通过lambda表达式创建线程进行处理
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (list) {
                    list.add(i + "");
                    if (list.size() == 5) {
                        list.notify();
                        System.out.println(Thread.currentThread().getName() + "发出通知了");
                    }
                    System.out.println(Thread.currentThread().getName() + ":添加到了第" + list.size() + "个");
//                    System.out.println("在notify之后该方法继续执行，说明notify方法不会释放锁！");
                }
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();


        //通过lambda表达式创建线程进行处理-测试notifyall
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (list) {
                    list.add(i + "");
                    if (list.size() == 5) {
                        list.notify();
                        System.out.println(Thread.currentThread().getName() + "发出通知了");
                    }
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + ":添加到了第" + list.size() + "个");
//                    System.out.println("在notify之后该方法继续执行，说明notify方法不会释放锁！");
                }

            }
        }).start();
    }
}
