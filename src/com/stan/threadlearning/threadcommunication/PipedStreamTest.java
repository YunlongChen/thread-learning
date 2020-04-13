package com.stan.threadlearning.threadcommunication;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//通过管道进行传输
public class PipedStreamTest {

    public static void main(String[] args) throws IOException {
        Object lock = new Object();
        PipedInputStream inputStream = new PipedInputStream();
        //在这个构造方法中包含了connect操作
        PipedOutputStream outputStream = new PipedOutputStream(inputStream);

//        inputStream.connect(outputStream);

        //写出线程
        Thread writeThread = new Thread(() -> {
            try {
                System.out.println("write:");
                outputStream.write("你是我的好朋友".getBytes());
                System.out.println(Thread.currentThread().getName() + "完成了一次发送！");
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //读取线程
        Thread readThread = new Thread(() -> {
            System.out.println("开始读取");
            byte[] bytes = new byte[1024];
            try {
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    String newDate = new String(bytes);
                    System.out.println("read:" + newDate);
                }
                inputStream.close();
                System.out.println(Thread.currentThread().getName() + "完成了一次接收！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        readThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writeThread.start();


    }
}
