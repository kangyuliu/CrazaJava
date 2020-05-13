package com.company;

public class UnderscoreTest {
    public static void main(String[] args){
        int binVal = 0b1000_0000_0000_0000_0000_0000_0000_0011;
        System.out.println("binVal=" + binVal);
        double pi = 3.14_15_92_65_36;
        System.out.println("pi=" + pi);
        double height = 8_8_4_8.2_3;
        System.out.println("height=" + height);

        var varInt = 10;
        System.out.println("varInt=" + varInt);

        var str = "Hello world...";
        str = "12222";
        System.out.println("str=" + str);
        //str = 12;

        byte bb = 9;
        //char ch = bb;

        short sVal = 5;
        sVal = (short) (sVal-2);

        var a2 = 5.4;
        var b2 = 0;
        System.out.println("a2 % b2 = " + (a2 % b2));

        byte b33 = (byte) 0b0011_0011;//51
        System.out.println("b33=" + b33);

        //取反
        int b44 = ~b33;//-51
        System.out.println("b44=" + b44);

        byte a3 = 5;
        //a3 = a3 + 5;
        a3 += 5;
        System.out.println(2 == 2.00);
        System.out.println(97 == 'a');

        Long L1 = new Long(1);
        Integer I1 = new Integer(1);
        //System.out.println(L1 == I1);

        var a = 5;
        var b = 10;
        if(a  >4 | b++ > 10){//a=5,b=11
            System.out.println("a = " + a + ", b = " + b);
        }
        /*if(a  >4 || b++ > 10){ //a=5,b=10
            System.out.println("a = " + a + ", b = " + b);
        }*/

    }

}
