package com.yamlee.api.thread;

import com.yamlee.api.log.Logger;

/**
 * Created by yamlee on 15/7/3.
 */
public class Synchronizition {
    private static boolean requtestStop;
    public static void main(String[] args) throws InterruptedException {
//        int i = 0;
//        while (true){
//            i++;
//            Logger.show("i:"+i);
//            if(i==10) break;
//        }

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(!requtestStop){
                    i++;
                    Logger.show("while loop i:"+i);
                }
                Logger.show("mythread end");
            }
        });
        myThread.start();
        Thread.sleep(250);
        requtestStop = true;
        Logger.show("main thread end...");
    }
}
