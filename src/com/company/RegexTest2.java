package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest2 {
    private static Pattern pattern = Pattern.compile("re\\w*");
    public static void main(String[] args){
        String[] msgs = {
          "Java has regular expressions in 1.4",
          "regular expressions now expressing in Java",
          "Java represses oracular expressions"
        };

        Matcher matcher = null;
        for(var i=0; i < msgs.length;i++){
            if(matcher == null){
                matcher = pattern.matcher(msgs[i]);

            }else {
                matcher.reset(msgs[i]);
            }
            System.out.println(matcher.replaceAll("haha:)"));
        }


    }
}
