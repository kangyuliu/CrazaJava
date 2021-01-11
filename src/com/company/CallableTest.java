package com.company;

import java.awt.image.VolatileImage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    volatile int[] arr= new int[10];
    volatile int a= 10;
    public static void main(String[] args){
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();

        //Servlet
        try {
            Thread.sleep(1000);
            System.out.println("返回结果 " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " main()方法执行完成");
    }


}
