package com.company;

import java.util.stream.StreamSupport;

public class StringCompareTest {

    final private int n;
    private static  int m;
    public StringCompareTest(final int n){
        this.n = n;
    }

    {
        m =101;
    }
    public StringCompareTest(){
        this.n = 0;
    }
    public static void main(String[] args){
        String str1 = "疯狂Java";
        var str2 = "疯狂";
        var str3 = "Java";
        var str4 = "疯狂" + "Java";
        var str5 = "疯" + "狂" + "Java";
        var str6= str2 + str3;
        var str7 = new String("疯狂Java");
        System.out.println(str1 == str4); //true
        System.out.println(str1 == str5); //true
        System.out.println(str1 == str6);//false
        System.out.println(str1 == str7);//false
        final int a;
        a =13;
        System.out.println(a);
        //a=14;
        System.out.println(new StringCompareTest(10).n);
        System.out.println(StringCompareTest.m);

    }

}
