package com.yamlee.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Liyan on 2015/4/23.
 */
public class ThreadMain {
    public static void main(String[] args){

        Thread thread1 = new Thread(new MyRunnable1());
        Thread thread2 = new Thread(new MyRunnable2());
        thread1.start();
        thread2.start();
        for (int i=0;i<200;i++){
            log("mainthread----"+i);
            if(i==100){
            }
        }
    }

    public static void log(String msg){
        System.out.println(msg);
    }

   static class MyRunnable1 implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<200;i++){
                log("runnable1----"+i);

                if(i==100){
                    try {
//                        log("runnable1--join--"+i);
//                        Thread.currentThread().join();
                        log("runnable1--sleeping--"+i);
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    static class MyRunnable2 implements  Runnable{

        @Override
        public void run() {
            for (int i=0;i<200;i++){
                log("runnable2----"+i);
            }
        }
    }
}
