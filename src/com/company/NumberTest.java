package com.company;

public class NumberTest {
    public static void main(String []args){
        //二进制
        int byteNum = 0B11111111;
        System.out.println("byteNum: " + byteNum);
        //八进制
        int octNum = 011;//8*1+1=9
        System.out.println("octNum=" + octNum);
        //十六进制
        int hexNum = 0xa1;//16*10+1=161
        System.out.println("hexNum=" + hexNum);

        //
        //int bigInt = 0b00000000000000000000000000000001;//1 都是补码
        int bigInt = 0b10000000000000000000000000000001;//1
        System.out.println("bigInt=" + bigInt);

        //byte
        byte byteInt = (byte)0b11101001;//15
        System.out.println("byteInt=" + byteInt);

    }

}
