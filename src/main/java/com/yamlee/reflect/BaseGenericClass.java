package com.yamlee.reflect;

/**
 * Created by yamlee on 5/18/16.
 */
public class BaseGenericClass<R> implements GenericInterface<R> {
    R result;

    @Override
    public R genericMethod(R obj) {
        return null;
    }
}
