package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args){
        List<String> list= new ArrayList<>(10);
        System.out.println(list.size());
        list.add("hhh");
        System.out.println(list.size());
    }
}
