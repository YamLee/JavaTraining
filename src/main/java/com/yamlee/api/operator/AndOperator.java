package com.yamlee.api.operator;

import com.yamlee.api.log.Logger;

/**
 * Created by yamlee on 15/6/29.
 */
public class AndOperator {
    private  int tempraryField = 2;
    private static int staticTempraryField = 3;
    public static void main(String[] args){
//        int a = 10;
//        int b = 11;
//        boolean judge = false;
////        Logger.show();
//        if(a>9 & b>9) {
//            System.out.println("true");
//
//        }
//        int longnum = 10000;
//        switch (longnum){
//            case 100:
//                break;
//        }

        AndOperator andoperator = new AndOperator();
        andoperator.start(new MyListener() {
            @Override
            public void onSuccess(boolean result) {
                Logger.show("innier class");
            }
        });
        String s = "hello";
    }

     class MyInnerClass{
        public  int i = 0;
         public void test(int param){
             i = tempraryField;
             i = staticTempraryField;
         }

    }

    public  void test(int param){
       final int temp =  0;

         class MethodClass{
            int result = temp * 2;

        }

        MethodClass methodClass = new MethodClass();
        methodClass.result = 2;

    }

    public void start(MyListener listener){
        for (int i = 0; i <10 ; i++) {
            if (i==5){
                listener.onSuccess(true);
            }
        }
    }

    public interface MyListener{
        void onSuccess(boolean result);
    }


}
