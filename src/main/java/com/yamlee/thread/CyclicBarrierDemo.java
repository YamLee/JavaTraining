package com.yamlee.thread;

import com.yamlee.log.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by yamlee on 15/7/8.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 3000;
        new HorseRace(nHorse, pause);
    }
}


class HorseRace {
    private static final int END_LINE = 75;
    private CyclicBarrier cyclicBarrier;
    private List<Horse> horses = new ArrayList<Horse>();

    public HorseRace(int nHorses, final int pause) {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        cyclicBarrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < END_LINE; i++) {
                    stringBuilder.append("=");
                }
                Logger.show(stringBuilder.toString());
                for (Horse horse : horses) {
                    Logger.show(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getStride() >= END_LINE) {
                        Logger.show(horse + " won!");
                        executorService.shutdownNow();
                        return;
                    }
                }
                try {
                    Logger.show("barrier action sleep " + pause + "  millsecond");
                    TimeUnit.MILLISECONDS.sleep(pause);
                    Logger.show("barrier current thread:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Logger.show("barrier sleep action interrupted!");

                }
            }
        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }
}

class Horse implements Runnable {
    private static int COUNTER = 0;
    private final int id = COUNTER++;
    private final CyclicBarrier cyclicBarrier;
    private int stride = 0;
    private final Random rand = new Random(47);

    public synchronized int getStride() {
        return stride;
    }

    Horse(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public String toString() {
        return "Horse id--->" + id;
    }

    public String tracks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getStride(); i++) {
            sb.append("*");

        }
        sb.append(id);
        return sb.toString();
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    stride += rand.nextInt(3);
                }
                Logger.show(this + " await");
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}