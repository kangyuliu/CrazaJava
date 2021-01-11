package com.company;

public class FinalizeTest {
    private static FinalizeTest ft = null;
    public void info(){
        System.out.println("测试资源管理的finalize方法");
    }

    public static void main(String[] args){
        new FinalizeTest();
        System.gc();//通知系统进行资源回收
        //System.runFinalization();//强制垃圾回收机制调用可恢复对象的finalize()方法
        Runtime.getRuntime().runFinalization();
        ft.info();
    }

    @Override
    public void finalize(){
        ft =this;
    }
}
