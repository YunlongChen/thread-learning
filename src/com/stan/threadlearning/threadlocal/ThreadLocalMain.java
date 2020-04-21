package com.stan.threadlearning.threadlocal;

/**
 * <h3>Exper1</h3>
 * <p></p>
 *
 * @author : cxc
 * @date : 2020-04-02 00:07
 **/
public class ThreadLocalMain {
    private static void incrementSameThreadId() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s_%d,threadId:%d%n", Thread.currentThread(), i, ThreadLocalId.get());
            }
        } finally {
            ThreadLocalId.remove();
        }
    }

    public static void main(String[] args) {
        incrementSameThreadId();
        new Thread(ThreadLocalMain::incrementSameThreadId).start();
        new Thread(ThreadLocalMain::incrementSameThreadId).start();
    }
}
