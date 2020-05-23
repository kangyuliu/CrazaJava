package com.company;

public class LocalInnerClass {
    public static void main(String[] args){
        //局部内部类在实际开发中很少使用
        class InnerBase{
            int a;
        }

        class InnerSub extends InnerBase{
            int b;
        }

        InnerSub is = new InnerSub();
        is.a = 10;
        is.b = 20;
        System.out.println("is.a = " + is.a + " is.b = " + is.b);
    }
}
