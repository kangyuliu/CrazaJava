package com.company;

import java.util.Scanner;

public class ScannerKeyBoardTest {
    public static void main(String[] args){
        var scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()){
            System.out.println("输入内容是: " + scanner.next());
        }
    }
}
