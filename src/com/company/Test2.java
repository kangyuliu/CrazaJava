package com.company;

public class Test2 {
    private static int i=0;
    public void add(){
        synchronized (Test2.class){
            i++;
        }
    }

    public static void main(String[] args){
        new Test2().add();
    }

}
