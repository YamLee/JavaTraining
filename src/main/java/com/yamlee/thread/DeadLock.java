package com.yamlee.thread;

/**
 * Created by yamlee on 9/2/16.
 */
public class DeadLock {

    public static void main(String[] args) throws InterruptedException {
//        deadLockTest();
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("available processors :"+i);
    }

    private static void deadLockTest() {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        System.out.println("thread 1 running...");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1) {
                        System.out.println("thread 2 running...");
                    }
                }
            }
        });
        System.out.println("main thread running....");
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
//        t1.join();
//        t2.join();
    }


}
