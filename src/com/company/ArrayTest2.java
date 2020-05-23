package com.company;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArrayTest2 {
    public static void main(String[] args){
       var arr1 = new int[] {3,-4,25,16,30,18};
       //对数组arr1进行并发排序
        Arrays.parallelSort(arr1);
        System.out.println("arr1: " + Arrays.toString(arr1));
        var arr2 = new int[]{3,-4,25,16,30,18};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left * right;
            }
        });
        //arr2: [3, -12,-300,-4800,...]
        System.out.println(Arrays.toString(arr2));

        var arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));//0,5,10,15,20
    }

}
