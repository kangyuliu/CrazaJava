package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args){
        //Array array = new Array();
        int[] ints = new int[10];
        for(int i=0, len = ints.length; i<len;i++){
            ints[i] = i;
        }

        int index = Arrays.binarySearch(ints,0, 10,6);
        System.out.println("index = " + index);

        int[] ints2 = Arrays.copyOf(ints, ints.length);
        for(int i=0, len = ints2.length; i < len; i++){
            System.out.print(ints2[i] + " ");
        }
        System.out.println("ints == ints2 ?: " + Arrays.equals(ints,ints2));
        System.out.println(Arrays.toString(ints));
    }
}
