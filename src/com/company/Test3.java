package com.company;

public class Test3 {
    private static int i=0;
    public synchronized void add(){
        i++;
    }

    public static void main(String[] args){
        new Test3().add();
        String str = "Hello world!";
        str.charAt(100);
    }
}
