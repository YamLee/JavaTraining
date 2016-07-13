package com.yamlee.thread;

import com.yamlee.log.Logger;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yamlee on 15/7/7.
 */
public class CountDownLatchDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i=0;i<10;i++){
            executorService.execute(new WaitingTask(countDownLatch));
        }
        for(int i=0;i<100;i++){
            executorService.execute(new ProduceTask(countDownLatch));
        }
        executorService.shutdown();
        Logger.show("executors shut down");
    }

}

class ProduceTask implements  Runnable{
    private static int COUNTER = 0;
    private final int id = COUNTER++;
    private final CountDownLatch countDownLatch;
    private final Random rand = new Random(47);

    ProduceTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ",id);
    }

    @Override
    public void run() {
        try {
            doWork();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Logger.show(this+"interrupted");
        }
    }

    private void doWork() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(rand.nextInt(2000));
        Logger.show(this+"completed");
    }
}


class WaitingTask implements  Runnable{
    private static int COUNTER = 0;
    private final int id = COUNTER++;
    private final CountDownLatch countDownLatch;
    private final Random rand = new Random(47);

    WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String toString() {
        return String.format("waitingtask %1$-3d ",id);
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            Logger.show("Latch barrier passed "+this);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Logger.show(this + "interrupted");
        }
    }



}
