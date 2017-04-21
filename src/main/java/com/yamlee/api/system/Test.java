package com.yamlee.api.system;

import java.util.*;
//import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception{
        Set<String> words = new HashSet<String>();

        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner("aa bb dd cc aa");
        //Scanner in = new Scanner(new File("D:/alice.txt"));
        System.out.println("stop input by enter:exit");
        while(in.hasNext()){
            String word = in.next();
            if(word.equalsIgnoreCase("exit")) break;
            words.add(word);

//            break;
        }

        Iterator<String> iter = words.iterator();
        for(int i=1; i<=20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(words.size());
    }
}
