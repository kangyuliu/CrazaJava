package com.company;

class BaseClass{
    public static void test(){}
}

class SubClass extends BaseClass{
    //public void test(){}
}


public class Varargs {

    //定义形参个数可变的方法
    public static void test(int a, String... books){
        for(var book : books){
            System.out.println(book);
        }
        System.out.println(a);
    }

    //定义形参是数组的方法
    public static void test2(int a, String[] books){
        for(var book : books){
            System.out.println(book);
        }
        System.out.println(a);
    }

    public static void main(String[] args){
        String[] books = {"CNN", "BBC","CCTV"};
        test(3,"CNN", "BBC","CCTV");
        test(3,books);
        //test2(3, "CNN", "BBC", "CCTV");
        test2(3, books);
        test(0);
        String str = "hello";
        System.out.println(str instanceof Object);//true
        System.out.println(str instanceof String);//true
        Object obj = "hello";
        System.out.println(obj instanceof Object);//true
        System.out.println(obj instanceof String);//true
        System.out.println(obj instanceof Math);
        //System.out.println(str instanceof Math);
    }
}
