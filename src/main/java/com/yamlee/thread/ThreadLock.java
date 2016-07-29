package com.yamlee.thread;

/**
 * Created by yamlee on 7/29/16.
 */
public class ThreadLock {
    public static void main(String[] args) throws InterruptedException {
        ThreadLock threadLock = new ThreadLock();
        threadLock.test3();
    }

    public void test1() throws InterruptedException {
        class Counter {
            private int count = 0;

            public void increament() {
                ++count;
            }

            public int getCount() {
                return count;
            }
        }

        final Counter counter = new Counter();
        class CounterThread extends Thread {
            private String tag;

            CounterThread(String tag) {
                super();
                this.tag = tag;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(tag + " run: " + i);
                    counter.increament();
                }
            }
        }
        CounterThread t1 = new CounterThread("t1");
        CounterThread t2 = new CounterThread("t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("result:" + counter.getCount());
    }

    static boolean answerReady = false;
    static int answer = 0;

    public void test2() throws InterruptedException {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                answer = 42;
                answerReady = true;
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                if (answerReady) {
                    System.out.println("the answer is:" + answer);
                } else {
                    System.out.println("I don't know answer");
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public void test3() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("from t1 thread");
            }
        };
        t1.start();
        Thread.yield();
        System.out.println("from main");
        t1.join();
    }
}
