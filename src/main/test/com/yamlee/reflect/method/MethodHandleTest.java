package com.yamlee.reflect.method;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.yamlee.reflect.method.MethodHandle.*;
import static org.junit.Assert.*;

/**
 * Created by yamlee on 7/13/16.
 */
public class MethodHandleTest {
    @Test
    public void testClass() throws Exception {
        Method[] declaredMethods = Demo.class.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            println("------------------------------------");
            Method declaredMethod = declaredMethods[i];
            System.out.println(declaredMethod.getName() + " isDefault:" + declaredMethod.isDefault());
            Type[] genericParameterTypes = declaredMethod.getGenericParameterTypes();
            if (genericParameterTypes.length == 0) continue;
            Type genericParameterType = genericParameterTypes[0];
            println("origin type:" + genericParameterType.getTypeName());
            println("origin type class:" + genericParameterType.getClass().getName());
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                String typeName = parameterizedType.getRawType().getTypeName();
                println("parameterize raw type:" + typeName);
            }

//            int[] objects = new int[2];

//            Object object = objects;

        }

    }
}