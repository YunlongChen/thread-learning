package com.stan.threadlearning.daemon;

public class DaemonThread extends Thread {

    @Override
    public void run() {
        System.out.println("subaru 君。你就认真工作吧，我会守护你的！");

        while (true) {
            System.out.println("加油哦，蕾姆还在哦");
            try {
                System.out.println("好困啊，这样带着也太无聊了，就要睡着了..");
                System.out.println("zZZ..");
                Thread.sleep(4000);

                System.out.println("完了，还答应了Subaru帮他盯着呢");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
