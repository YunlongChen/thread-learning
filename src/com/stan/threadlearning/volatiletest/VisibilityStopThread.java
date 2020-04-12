package com.stan.threadlearning.volatiletest;

public class VisibilityStopThread extends Thread {
    private Service service;

    public VisibilityStopThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.stopService();
    }
}
