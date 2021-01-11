package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fib {

   private static Pattern pattern = Pattern.compile("");
   private static Matcher matcher = pattern.matcher("");

    public static int fib(int n) {
        matcher.find();
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        ok:
        for(int i=2; i <=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            break ok;
        }
        return dp[n] % 1000000007 ;
    }

    public static void main(String[] args){
        //fib(48);
        int[][] a = new int[10][10];
        for(int i=0; i<10;i++){
            for (int j=0; j < 10; j++){
                System.out.println(a[i][j]);
            }
        }
    }
}
