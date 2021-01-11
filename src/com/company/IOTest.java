package com.company;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class IOTest {
    public static void func()throws Exception{
        OutputStream outputStream = new FileOutputStream("test.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeLong(12L);
    }

   public static void main(String[] args){
        //func();
   }

}
