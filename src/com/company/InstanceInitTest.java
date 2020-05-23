package com.company;

public class InstanceInitTest {

    private int a =9;
    //{a = 6;}
    {a = 12;}
    public static void main(String[] args){
        //Integer
        Object object = Integer.valueOf(1);
        Object object2 = new Integer(10);
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(2);
        Integer.compare(integer1, integer2);
        int sub = integer2 - integer1;
        System.out.println("sub = " + sub );
        int a = Integer.parseInt("A0", 16);//160
        int b = Integer.valueOf("11",2);//3
        System.out.println(new InstanceInitTest().a);
        System.out.println(a);
        System.out.println(b);
        var d = String.valueOf(1.23);
        var f = String.valueOf(4.56f);
        var t = String.valueOf(true);
        System.out.println(t);
        Character c = 'a';
        byte b1 = -3;
        System.out.println(Byte.toUnsignedInt(b1));
    }
}
