package com.yamlee.thread;

/**
 * Created by Liyan on 2015/4/27.
 */
public class ThreadInterrupt {
    public static void main(String[] args){
            Thread thread = new Thread(new MyRunnable());
            thread.start();
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i =0;i<200;i++){
                System.out.println("i="+i);
                if(i==100){
                    Thread.currentThread().interrupt();
                    System.out.println("set interrupt");
                }
                if(Thread.interrupted()){
                    try {
                        Thread.sleep(5000);
                        System.out.println("sleeping");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}
