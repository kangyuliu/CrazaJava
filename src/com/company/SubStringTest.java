package com.company;

import java.util.HashSet;
import java.util.Set;

public class SubStringTest {
    public static void main(String[] args){
        String str = "Cassste";
        Set<Character> set= new HashSet<>();
        int[] a = {1,2,2,5};
        int len =a.length;
        for(int i=0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            set.add(str.charAt(i));
        }

        if(set.contains('C')){
            System.out.println("###");
        }
set.clear();
    }

}
