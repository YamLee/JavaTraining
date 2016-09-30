package com.yamlee.thread;

/**
 * Created by yamlee on 9/21/16.
 */
public class MemoryModel {
    private static boolean run = true;
    //    private static volatile boolean run = true;
    private static long i = 0;
    private static String msg;
    static int a, b,c;

    public static void main(String[] args) throws InterruptedException {
        visibilityTest();
//        atomicityTest();
//        ordering();
    }

    private static void ordering() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                i = 10;
//                run = false;

                a=2;
                c =10;
                c =11;
                b=3;
                c = 12;

//                a=1;
//                b=a;

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (b == 3) {
                    System.out.println("c is "+c);
                }
//                if (run) {
//                    msg = "I am running " + i;
//                } else {
//                    msg = "I am not running " + i;
//                }

            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
//        thread2.join();
//        System.out.println(msg);
    }

    /**
     * 原子性测试
     */
    private static void atomicityTest() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int j = 0;
                while (j < 100) {
                    j++;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i is:" + i);
                }

            }
        });
        thread.start();
        Thread.sleep(1000);
        i = 100;
    }


    /**
     * 内存可见性测试
     */
    private static void visibilityTest() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    i++;
//                    synchronized (this) {}
//                    System.out.print(" new thread running....\n");
                }
            }
        });
        //新建线程开始运行
        thread.start();
        //主线程sleep 1秒
        Thread.sleep(1000);
        run = false;
        thread.join();
        System.out.println("i is:" + i);
        System.out.println("main thread done");
    }
}
