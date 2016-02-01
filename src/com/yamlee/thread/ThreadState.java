package com.yamlee.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by yamlee on 15/7/8.
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StateRunnalble());
        showState(thread);
        thread.start();
        showState(thread);
        while(true){
            TimeUnit.SECONDS.sleep(1);
            showState(thread);
        }


    }

    public static void showCurrentThreadState(){
        System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().getState());
    }

    public static void showState(Thread thread){
        System.out.println(thread.getName() + "  " + thread.getState());
    }


}

class StateRunnalble implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
