package com.company;

public class SwitchTest {
    public static void main(String[] agrs){
        int[] intArray;
        intArray = new int[10];
        intArray[0] =11;
        var inta = new int[]{1,2,3,4,5};

        int[] ints = {1,2,3,4};
        System.out.println(inta[4]);
        System.out.println(intArray[0]);
        System.out.println(intArray[9]);
        var score = "c";
        switch (score){
            case "a":
                System.out.println("优秀");
                break;
            case "b":
                System.out.println("良");
                break;
            case "c":
                System.out.println("中");
                //break;
            case "d":
                System.out.println("及格");
                //break;
            case "e":
                System.out.println("不及格");
                //break;
            default:
                System.out.println("差");
        }
    }
}
