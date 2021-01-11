package com.company;

import java.util.*;

public class CollectionTest {

    public static void main(String[] args){
        String str = "araaci";
        int k = 2;
       int ret =  findLength(str, 2);
       System.out.println(ret);
    }


    public static int findLength(String str, int k) {
        // TODO: Write your code here
        if(str.length() <= 0 || k <= 0){
            return 0;
        }
        int maxSubSize = 0;
        int cnt = 0;
        HashMap<Character, Integer> map =  new HashMap<Character, Integer>();

        Set<Character> set = new HashSet<>();
        for(int left=0; left < str.length(); left++){
            for(int right = left; right < str.length(); right++){
                if(set.size() <= k){
                    if(!set.contains(str.charAt(right))){
                        set.add(str.charAt(right));
                        if(set.size() == k+1){
                            set.clear();
                            cnt = 0;
                            break;
                        }
                    }
                    cnt ++;
                    if(maxSubSize < cnt){
                        maxSubSize = cnt;
                    }
                }
                set.clear();
                cnt = 0;
            }
        }
        return maxSubSize;
    }


   public static int totalFruit(int[] trees){
        int maxCnt = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int end=0; end < trees.length; end++){
            map.put(trees[end], map.getOrDefault(trees[end], 0)+1);
            while (map.size() > 2){
                map.put(trees[start], map.get(trees[start])-1);
                if(map.get(trees[start]) == 0){
                    map.remove(trees[start]);
                }
                start++;//右移
            }
            maxCnt = Math.max(maxCnt, end - start +1);
        }
        return maxCnt;
    }

    private static int findLongestSubstringWithoutRepeated(String str){
        if(str == null || str.length() ==0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        for(int left=0; left < str.length(); left++){
            int cnt = 0;
            for (int right = left; right < str.length(); right++){
                if(!set.contains(str.charAt(right))){
                    cnt++;
                }else {
                    maxLen = Math.max(maxLen, cnt);
                    set.clear();
                    break;
                }
            }
            maxLen = Math.max(maxLen, cnt);
        }
        return maxLen;
    }
}
