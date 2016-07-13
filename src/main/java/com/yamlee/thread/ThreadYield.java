package com.yamlee.thread;

/**
 * Created by Liyan on 2015/4/27.
 */
public class ThreadYield {
    public static void main(String[] args){
            for (int i=0;i<3;i++){
                Thread thread = new Thread(new YieldRunnable(i));
                if(i==0) {
                    thread.setPriority(Thread.MAX_PRIORITY);
                }
                if(i==1){
                    thread.setPriority(Thread.NORM_PRIORITY);
                }
                if(i == 2){
                    thread.setPriority(Thread.MIN_PRIORITY);
                }
                thread.start();
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {

                    }
                });
            }
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
