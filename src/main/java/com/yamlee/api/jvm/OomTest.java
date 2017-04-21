package com.yamlee.api.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yamlee on 9/20/16.
 */
public class OomTest {

//    public static void main(String[] args) {
//        OomTest oomTest = new OomTest();
//        oomTest.test2();
//    }

    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧", "pwd1", 25);
        Person p2 = new Person("孙悟空", "pwd2", 26);
        Person p3 = new Person("猪八戒", "pwd3", 27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:3 个元素!
        p3.age = 2; //修改p3的年龄,此时p3元素对应的hashcode值发生改变

        set.remove(p3); //此时remove不掉，造成内存泄漏

        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set) {
            System.out.println(person);
        }
    }

//    public void test1() {
//        List<Person> persons = new ArrayList<>();
//        Person person1 = new Person("zhangsan", "12");
//        persons.add(person1);
//        person1.name = "liyan";
//        persons.remove(person1);
//        print("person list size:" + persons.size());
////        print("person 1:" + persons.get(0).name);
//    }
//
//    public void test2() {
//        Set<Person> persons = new HashSet<>();
//        Person person1 = new Person("Jane", "12");
//        Person person2 = new Person("Michale", "13");
//        Person person3 = new Person("Marya", "14");
//
//        persons.add(person1);
//        persons.add(person2);
//        persons.add(person3);
//        print("person sets size:" + persons.size());
//
//        person1.name = "Lee";
//        persons.remove(person1);
//
//        print("person sets size:" + persons.size());
//
//        persons.add(person1);
//        print("person sets size:" + persons.size());
//
//    }
//
//    private void print(String msg) {
//        System.out.println(msg);
//    }

   static class Person {
        public String name;
        public int age;
        public String pwd;

        public Person(String name, String pwd, int age) {
            this.name = name;
            this.age = age;
            this.pwd = pwd;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
