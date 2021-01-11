package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {


    public static void main(String[] args){
        String regex="a*b";
        Pattern pattern= Pattern.compile(regex);
        String str1 ="aaab";
        Matcher matcher = pattern.matcher(str1);
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.matches());
        System.out.println(matcher.find());


    }

}
