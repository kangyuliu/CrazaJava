package com.company;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

    private static void hello(){
        System.out.println("Hello world!");
    }

    private  String hello(String name){
        System.out.println("执行带参数的hello " + name);
        return name + ",你好";
    }

    public static void main(String[] args)throws Throwable{
        var type = MethodType.methodType(void.class);
        MethodHandle mtd = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", type);
        mtd.invoke();
        var type2= MethodType.methodType(String.class, String.class);
        MethodHandle mtd2 = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello", type2
                );
       System.out.println(mtd2.invoke(new MethodHandleTest(), "lky"));
    }

}
