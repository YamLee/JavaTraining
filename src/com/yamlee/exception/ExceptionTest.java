package com.yamlee.exception;

import com.yamlee.log.Logger;

/**
 * Created by yamlee on 15/6/29.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        Logger.show("result--" + exceptionTest.getResult().i);
        sayTest("hello");
        sayTest("test");
    }

    private static void sayTest(String test) {
        System.out.println(test);
    }

    public MyModel getResult() {
        Integer i = new Integer(5);
        MyModel model = new MyModel();
        model.i = 5;
        try {
            return model;
        } catch (Exception e) {

        } finally {
            ++model.i;
            Logger.show("finnally excute");
        }
        return model;
    }


    public class MyModel {
        int i = 0;

        public void saySth() {
            int a = 1;
        }
    }


}
