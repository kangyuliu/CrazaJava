package com.company;
import com.company.com.company.MyOutput;
import com.yitu.*;
public class OutPutFieldTest {
    public static void main(String[] args){
        System.out.println(Output.MAX_CACHE_LINE);
        //Output.MAX_CACHE_LINE = 100;
        System.out.println(Output.staticTest());
        Output output = (Output) new MyOutput();
        System.out.println(MyOutput.MAX_CACHE_LINE);
        new MyOutput().test();
    }
}
