package com.yamlee.api.reflect;

import java.util.List;

/**
 * Created by yamlee on 5/18/16.
 */
public class GenericClass extends BaseGenericClass<List> implements GenericInterface<List>, CommonInterface {

    @Override
    public Integer commonMethod(Integer obj) {
        return obj;
    }

    @Override
    public List genericMethod(List obj) {
        super.genericMethod(obj);
        return obj;
    }

    public String myMethod() {
        return "myMethod";
    }

}
