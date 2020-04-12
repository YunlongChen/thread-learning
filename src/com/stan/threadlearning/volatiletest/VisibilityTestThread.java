package com.stan.threadlearning.volatiletest;

/**
 * 线程私有变量可见性测试
 */
public class VisibilityTestThread extends Thread {

    private Service service;

    public VisibilityTestThread(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.runService();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始进行测试");
        Service service = new Service();
        VisibilityTestThread thread = new VisibilityTestThread(service);
        thread.start();
        Thread.sleep(1000);
        //直接使用对象本身来对线程的执行情况进行处理是可以可以马上看到执行效果的
        service.stopService();
        System.out.println("当前线程:" + Thread.currentThread().getName());
        System.out.println("工作线程:" + thread.getName());
        //通过主线程来对其他线程进行处理
//        new VisibilityStopThread(service).start();
        System.out.println("已经发送停止命令了！");
    }
}
