package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAddAll {

    public static void main(String[] args){
        System.out.println(getInt());
        try {
            System.out.println("Hello world.");
        }finally {
            System.out.println("Hello world2.");
        }
        List<String> list = Arrays.asList("hi", "beijin");
        List<String> list2 = new ArrayList<>();
        list2.addAll(list);
        list.set(0, "hello");
        System.out.println("list: " + list.toString());
        System.out.println("list2: " + list2.toString());
    }

    public static int getInt(){
        int a = 10;
        try {
            System.out.println(a /0);
        }catch (ArithmeticException e){
            a = 30;
            return a;
        }finally {
            a = 40;
            return a;
        }
        //return a;
    }
}
