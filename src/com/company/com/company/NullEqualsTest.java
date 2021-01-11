package com.company.com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NullEqualsTest {
    public static void main(String [] args){
        String str1 = null;
        String str2 = null;
        if(str1 == str2){
            System.out.println("it is equals.");
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        Integer[] array = set.toArray(new Integer[set.size()]);

    }
}
