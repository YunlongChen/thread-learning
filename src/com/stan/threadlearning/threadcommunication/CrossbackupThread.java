package com.stan.threadlearning.threadcommunication;

/**
 * 交叉备份测试
 */
public class CrossbackupThread {

    volatile private boolean prevIsA = true;

    public static void main(String[] args) {


        CrossbackupThread thread = new CrossbackupThread();


        new Thread(() -> {

            try {
                thread.backUpA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {

            try {
                thread.backUpB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    synchronized public void backUpA() throws InterruptedException {

        do {
            while (prevIsA) {
                wait();
            }

            System.out.println("※※※※※※※");

            prevIsA = true;

            notifyAll();
        } while (true);
    }

    synchronized public void backUpB() throws InterruptedException {
        while (true) {
            while (!prevIsA) {
                wait();
            }

            System.out.println("XXXXXXX");

            prevIsA = false;

            notifyAll();
        }
    }
}
