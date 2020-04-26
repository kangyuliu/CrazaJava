package com.company;

public class CharTest {
    public static void main(String[] args){
        char aChar = 'a';//直接指定单个字符作为字符值,97
        System.out.println("aChar="+aChar);
        System.out.println("aChar="+(int)aChar);
        char bChar = 98;
        System.out.println("bChar="+bChar);//b
        System.out.println("aChar+bChar=" + (aChar+bChar));

        char enterChar = '\r';
        System.out.println("enterChar=" + enterChar);

        char ch = '\u9999';
        System.out.println("ch=" + ch);
         char ch2 = '香';
         System.out.println("ch2 to int : " + (int)ch2);


    }

}
