package com.company;

import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args){
        var str = new String("Java");
        var wr = new WeakReference(str);//弱引用和str引用同一个对象
        str = null;//切断str与所引用对象的关联
        System.out.println(wr.get());//Java
        System.gc();
        System.runFinalization();//强制垃圾回收
        System.out.println(wr.get());//null
    }
}
