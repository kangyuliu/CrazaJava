package com.company;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class TreadPoolExecutorDemo {
    public static void main(String[] args){
        test3();
    }

    public static void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future future = executorService.submit(() -> {
                while (true) {
                    //1.如何捕获异常
                    try {
                        System.out.println("current thread name" + Thread.currentThread().getName());
                        Object object = null;
                        System.out.print("result## " + object.toString());
                    }catch (Exception e){
                        System.out.println("has exception.");
                    }
                }
            });
            try {
                future.get();
            }catch (Exception e){

            }
        }
    }

    //方法2,处理线程池异常
    public static void test2(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future future = executorService.submit(() -> {
                while (true) {
                    System.out.println("current thread name" + Thread.currentThread().getName());
                    //Object object = null;
                    //System.out.print("result## " + object.toString());
                }
            });
            try {
                future.get();
            }catch (Exception e){
                System.out.println("has exception2.");
            }
        }
    }

    public static void test3(){
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(
                        (t1, e) -> {
                            System.out.println(t1.getName() + "线程抛出的异常"+e);
                        });
                return t;
            }
        };
        ExecutorService threadPool = Executors.newFixedThreadPool(1, threadFactory);
        threadPool.execute(()->{
            Object object = null;
            System.out.print("result## " + object.toString());
        });
    }

}
