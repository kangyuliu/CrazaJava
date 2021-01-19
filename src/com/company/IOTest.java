package com.company;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public class IOTest {
    public static void func()throws Exception{
        OutputStream outputStream = new FileOutputStream("test.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeLong(12L);
    }

   public static void main(String[] args)throws IOException{
        //func();
       Selector selector = Selector.open();
       ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
       serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
       selector.select();
   }

}
