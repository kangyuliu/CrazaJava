package com.company;

import java.util.regex.Pattern;

public class ValidTest {
    private static String pattern = "^*[a-zA-Z_]+[a-zA-Z0-9]+$";
    public static void main(String[] args){


        //校验namespace是否合法，namaspace只允许字母，数字和下划线
        System.out.println(validNamespace(""));
    }

    private static boolean validNamespace(String namespace){
        return Pattern.matches(pattern, namespace);
    }
}
