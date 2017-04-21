package com.yamlee.api.reflect.method;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yamlee on 7/12/16.
 */
public class MethodHandle {
    private List<Map<String, Map>> list;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        testMethods();

        testClass();

//        testDefaultMethod();
        testProxy();
    }

    private static void testProxy() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Demo demo = (Demo) Proxy.newProxyInstance(Demo.class.getClassLoader(), new Class<?>[]{Demo.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("set value and arg is:" + args);
                return proxy;
            }
        });
//        demo.print1("test");

        People people = (People) Class.forName(People.class.getName().toString()).newInstance();
        people.printlnName();
    }

/*    private static void testDefaultMethod() {
        Demo demo = new Demo() {
            @Override
            public void print1(ArrayList value) {

            }

            @Override
            public void print2(String value) {

            }

            @Override
            public void print3() {
                System.out.print("print3 override");
            }
        };
        demo.print3();
    }*/

    private static void testClass() {
        int[] intNum = new int[2];
        println(intNum.getClass().getName());
        Integer[] inegertNum = new Integer[2];
        println(inegertNum.getClass().getName());

        String[] aString= new String[2];
        println(aString.getClass().getName());

        float[] aFloate = new float[2];
        println(aFloate.getClass().getName());



//        String str = "";
//        println(str.getClass().getName());
//
//                Class clazz1 = int.class;
//        Class clazz2 = Integer.class;
//        println(clazz1.getName());
//        println(clazz2.getName());
//        println((clazz1 == clazz2) + "");
//        Object objectInt = intNum;
//
//        println((objectInt instanceof Integer) + "");
//        println(intNum);
    }

    private static void testMethods() {
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

    public static void println(String msg) {
        System.out.println(msg);
    }

    public interface Demo {
        int value = 1;

        void print1(ArrayList<String>[] value);

        void print2(String value);

        default void print3() {
            System.out.println("set value 3");
        }
    }

    static class People {
        private String name;

        private void printlnName() {
            System.out.println("yam");
        }
    }


}
