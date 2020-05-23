package com.company;

public class PrintErrorTest {
    final int age;
    {
        //System.out.println(age);
        printAge();
        age = 6;
        System.out.println(age);
    }

    public void printAge(){
        System.out.println(age);
    }

    public static void main(String[] args){
        new PrintErrorTest();
    }
}
