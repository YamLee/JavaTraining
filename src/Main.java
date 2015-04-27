public class Main {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
//        log("new thread state:"+thread.getState().toString());
        thread.start();
//        log("run thread state:" + thread.getState().toString());
//        try {
//            thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log("sleep thread state:" + thread.getState().toString());

        Thread thread2 = new Thread(){
            public void run(){

                for (int i=0;i<100;i++){
//                    log("thread2 run for method state befor:" + this.getState().toString());
                    log("thread2 run i: "+i);
                    if(i>50&&i<60){
                        this.interrupt();
                        log("interrupted---"+isInterrupted());
//                        try {
//                            this.sleep(5000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
//                    log("thread2 run for method state after:" + this.getState().toString()+"\n");
                }
            }
        };
//        log("thread2 new state:"+thread2.getState().toString());
        thread2.start();
//        log("thread2 start state:"+thread2.getState().toString());

    }

    public static void log(String msg){
        System.out.println(msg);
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {

            for (int i=0;i<100;i++){
                System.out.println("thread run i:"+i);
            }
        }
    }

}
