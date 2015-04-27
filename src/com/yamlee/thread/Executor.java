package com.yamlee.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liyan on 2015/4/27.
 */
public class Executor {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExecutorRunnable());
//        executorService
    }

    static class ExecutorRunnable implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<100;i++){
                System.out.println("-------"+i);
            }
        }
    }
}
