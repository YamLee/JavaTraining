package com.yamlee.thread;

/**
 * Created by Liyan on 2015/4/27.
 */
public class ThreadYield {
    public static void main(String[] args){
            for (int i=0;i<10;i++){
                Thread thread = new Thread(new YieldRunnable(i));
                thread.start();
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
            Thread.yield();
//            Thread.yield();
            System.out.println("-------end---------"+i);
        }
    }
}
