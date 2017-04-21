package com.yamlee.api.grammar;

/**
 * Created by yamlee on 9/6/16.
 */
public abstract class AbstractClassDemo {
    public void print(String msg) {
        System.out.println(msg);
    }

    public void print2(String msg) {
        System.out.println(msg);
    }

    public void print3(String msg) {
        System.out.println(msg);
    }

    public void print4(String msg) {
        System.out.println(msg);
    }


    public static void main(String[] args) {
        AbstractClassDemo abstractClassDemo = new AbstractClassDemo() {
        };
    }
}
