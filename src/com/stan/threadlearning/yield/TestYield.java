package com.stan.threadlearning.yield;

public class TestYield {
    public static void main(String[] args) {
        new Thread(TestYield::run).start();
    }

    private static void run() {
        long startTime = System.currentTimeMillis();

        int count = 0;

        for (int i = 0; i < 50000000; i++) {
//            yield 会释放资源给优先级高于或者相同与自己的其他线程，如果当前线程优先级最高，并且优先级列表中仅有自己，name他会继续执行
//            Thread.yield();
            count += (i + 1);
        }
        System.out.println("计算结果：" + count);
        long endTime = System.currentTimeMillis();

        System.out.println("总共用时" + (endTime - startTime));
    }
}
