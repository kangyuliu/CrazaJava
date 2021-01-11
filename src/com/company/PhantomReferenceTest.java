package com.company;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public static void main(String[] args){
        var str = new String("Java in action");
        var rq = new ReferenceQueue<>();
        var pr = new PhantomReference(str, rq);//创建一个虚引用，并且与str引用同一个对象
        str = null;//切断str与所引用的对象的关联
        System.out.println(pr.get()); //null
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        System.out.println(pr.get());
        System.out.println(rq.poll() == pr);
    }
}
