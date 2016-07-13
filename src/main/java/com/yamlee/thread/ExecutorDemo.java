package com.yamlee.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liyan on 2015/4/27.
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.execute(new ExecutorRunnable1());
        executorService.execute(new ExecutorRunnable2());
//        executorService
    }

    static class ExecutorRunnable1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable one------" + i);
            }
        }
    }

    static class ExecutorRunnable2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable tow-------" + i);
            }
        }
    }
}
