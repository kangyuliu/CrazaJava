package com.company;

import java.util.zip.DeflaterOutputStream;

public class FloatTest {

    public static void main(String [] args){
        float af = 5.2345557f;
        System.out.println("af=" + af);

        double a = 0.0;
        double c = Double.NEGATIVE_INFINITY;
        float d = Float.NEGATIVE_INFINITY;
        System.out.println(c == d);

        double pc = Double.POSITIVE_INFINITY;
        float pd = Float.POSITIVE_INFINITY;
        System.out.println(pc == pd);
        System.out.println(d == pd);
        System.out.println(a / a);
        System.out.println(6.0 / a);
        System.out.println((-6.0) / a);

        System.out.println(0/0.0);
    }
}
