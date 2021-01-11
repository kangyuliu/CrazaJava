package com.company;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

public class MyCallable implements Callable<String> {
    ExecutorService service = Executors.newFixedThreadPool(5);
    @Override
    public String call() throws Exception {
        //HashMap
        System.out.println(Thread.currentThread().getName() + " call()方法执行中...");
        return "callable";
    }
}
