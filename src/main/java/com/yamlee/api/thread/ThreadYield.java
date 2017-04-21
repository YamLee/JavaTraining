package com.yamlee.api.thread;

/**
 * Created by Liyan on 2015/4/27.
 */
public class ThreadYield {
    public static void main(String[] args){
//            for (int i=0;i<3;i++){
//                Thread thread = new Thread(new YieldRunnable(i));
//                if(i==0) {
//                    thread.setPriority(Thread.MAX_PRIORITY);
//                }
//                if(i==1){
//                    thread.setPriority(Thread.NORM_PRIORITY);
//                }
//                if(i == 2){
//                    thread.setPriority(Thread.MIN_PRIORITY);
//                }
//                thread.start();
//                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//                    @Override
//                    public void uncaughtException(Thread t, Throwable e) {
//
//                    }
//                });
//            }

        Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello from mThread");
            }
        });
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        mThread.setPriority(Thread.MAX_PRIORITY);
        mThread.setDaemon(true);
        mThread.start();

        Thread.yield();
        System.out.println("main");
//        try {
//            mThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("main after join");
    }

    static class YieldRunnable implements  Runnable{
        int i ;
        public YieldRunnable(int i) {
            this.i =  i;
            System.out.println("-------start---------"+i);
        }

        @Override
        public void run() {
            System.out.println("-------run---------"+i);
            Thread.yield();
//            Thread.yield();
//            Thread.yield();
            System.out.println("-------end---------"+i);
        }
    }
}
