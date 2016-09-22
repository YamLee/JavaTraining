package com.yamlee.jvm;

/**
 * Created by yamlee on 9/19/16.
 */
public class JvmStackMemory {
    public static void main(String[] args) {
        JvmStackMemory stackMemory = new JvmStackMemory();
        stackMemory.test(0);
    }

    /**
     *方法栈深度大于虚拟机最大允许方法栈深度,则会报StackOverFlowError
     */
    public int test(int i) {
        if (i == 100000) {
            return i;
        } else {
            i++;
            System.out.println("method i ++:" + i);
            return test(i);
        }
    }
}
