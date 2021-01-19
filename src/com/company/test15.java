package com.company;

import java.util.HashSet;

public class test15 {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(256);
        if(set.contains(1)){
            System.out.println("set contains 1.");
        }
        if(set.contains(256)){
            System.out.println("set contains 256.");
        }
    }
}
