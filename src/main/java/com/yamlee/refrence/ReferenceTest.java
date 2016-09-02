package com.yamlee.refrence;

/**
 * Created by yamlee on 7/29/16.
 */
public class ReferenceTest {
    static class People {
        private String name;

        public People(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static People p1;

    public static void main(String[] args) {
//        p1 = new People("zhsan");
//        ReferenceTest referenceTest = new ReferenceTest();
//        referenceTest.test(p1);
//        System.out.println(p1.getName());
//        People pp = new People("pp");
//        People p11 = pp;
//        People p22 = pp;
//        System.out.println(p11 == p22);
        System.out.println((1f)==1);

    }

    public void test(People people) {
//        people = new People("2");

    }

}
