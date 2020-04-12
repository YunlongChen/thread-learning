package com.stan.threadlearning.sychronized;

public class MySubObject extends MyObject {
    /**
     * 直接调用父类的方法是可以保持同步的
     *
     * @throws Exception
     */
    @Override
    public void methodA() throws Exception {
        super.methodA();
    }

    //同步方法不能够直接继承，在重写的时候需要在方法上面通过显示添加关键字的酱子类的方法标志位同步方法
    @Override
    public synchronized void methodB() {
        System.out.println("this is methodB；" + System.currentTimeMillis());
        System.out.println("开始运行B方法,调用线程：" + Thread.currentThread().getName());

        value = 2;
        System.out.println("endB endTime:" + System.currentTimeMillis());
        System.out.println(value);
    }
}
