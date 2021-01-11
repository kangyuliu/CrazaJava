package com.company;

public class UglyNumber {

    public static int getNthUglyNum(int n){
        if(n <=0) return 0;
        int[] uglyNums = new int[n];
        uglyNums[0]=1;
        int p2 = 0, p3=0, p5=0;
        for(int i=1; i < n; i++){
            int ugly = Math.min(Math.min(uglyNums[p2]*2, uglyNums[p3]*3), uglyNums[p5]*5);
            uglyNums[i] = ugly;
            if(ugly == uglyNums[p2]*2) p2++;
            if(ugly == uglyNums[p3]*3) p3++;
            if(ugly == uglyNums[p5]*5) p5++;
        }

        return uglyNums[n-1];
    }

    public static void main(String[] args){
        int ugly = getNthUglyNum(10);
        System.out.println(ugly);
    }
}
