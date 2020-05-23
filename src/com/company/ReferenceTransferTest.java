package com.company;

class DataWrap{
    int a;
    int b;
}

public class ReferenceTransferTest {
    public static void main(String[] args){
        DataWrap dw = new DataWrap();
        dw.a = 6;
        dw.b = 9;
        System.out.println("交换之前,成员变量a的值: " + dw.a + ",成员变量b的值: " + dw.b);
        swap(dw);
        System.out.println("交换之后,成员变量a的值: " + dw.a + ",成员变量b的值: " + dw.b);
    }

    public static void swap(DataWrap dw){
        var tmp = dw.a;
        dw.a = dw.b;
        dw.b = tmp;
        System.out.println("swap方法中,成员变量a的值: " + dw.a + ",成员变量b的值: " + dw.b);
    }
}
