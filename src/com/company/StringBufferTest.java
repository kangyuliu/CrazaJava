package com.company;

import java.util.*;

public class StringBufferTest {

    public static String getNoRepeatedSubstring(String s){
        if(s == null || s.length() <= 1){
            return s;
        }

        StringBuffer sb = new StringBuffer(s);
        int start = 0;
        int end = sb.length()-1;
        while(start < end){
          if(sb.charAt(start) == sb.charAt(end)){
              for(int i=start+1; i < end-1; i++){

              }
          }else if(sb.charAt(start) > sb.charAt(end)){
              start++;
          }else {
              end--;
          }
        }


        return new String(sb);
    }

    //方法１
    public static String removeDuplicateLetters(String s){
       LinkedList<Character> stack = new LinkedList<>();
       Map<Character, Integer> map = new HashMap<>();
       for(char ch : s.toCharArray()){
           map.put(ch, map.getOrDefault(ch,0)+1);
       }

       for(char ch : s.toCharArray()){
           if(!stack.contains(ch)){//add ch
               while(stack.size() > 0 && stack.peekLast() > ch && map.get(stack.peekLast()) > 1){
                   stack.removeLast();
               }
               stack.addLast(ch);
           }
           map.put(ch, map.get(ch)-1);
       }

       StringBuilder sb = new StringBuilder();
       for(char ch : stack){
           sb.append(ch);
       }
        return sb.toString();
    }

    //方法2
    public static String removeDuplicateLetters2(String s){

        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Integer> lastAppear = new HashMap<>();
        for(int i =0; i < s.length(); i++){//统计ch出现次数
            char ch = s.charAt(i);
            lastAppear.put(ch, i);
        }

        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.contains(ch)){
                while(stack.size() > 0 && stack.peekLast() > ch && lastAppear.get(stack.peekLast()) > i){
                    stack.removeLast();
                }
                stack.addLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String removeKDigits(String num, int k){
        LinkedList<Character> stack = new LinkedList<>();
        for(Character digit : num.toCharArray()){
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit){
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }

        for(int i=0; i < k;i++){
            stack.removeLast();
        }

        StringBuffer ret = new StringBuffer();
        boolean zeroLeading = true;
        for(Character digit : stack){
            if(zeroLeading && digit == '0'){
                continue;
            }
            zeroLeading = false;
            ret.append(digit);
        }
        if(ret.length() == 0) {
            return "0";
        }
        return new String(ret);
    }

public static int[] findMaxNumber(int[] nums, int k){
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0; i< nums.length;i++){
            while(stack.size() > 0 && stack.size()+nums.length-i > k && stack.peekLast() < nums[i]){
                stack.removeLast();
            }
            stack.addLast(nums[i]);
        }

        int len = stack.size();
        for(int i=0; i< len -k;i++){
            stack.removeLast();
        }
        int[] ret = new int[k];
        for(int i=0; i< k;i++){
            ret[i] = stack.get(i);
        }
        return ret;
}

public static int[] merge(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ret = new int[len1 + len2];
        int i=0;
        int j=0;
        int index = 0;
        while(i < len1 && j<len2){
            ret[index++] = nums1[i] > nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < len1){
            ret[index++] = nums1[i++];
        }

        while(j < len2){
            ret[index++] = nums2[j++];
        }

        return ret;
 }

    public static boolean greater(int[] nums1, int i, int[] nums2, int j){
        while(i< nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j==nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public static boolean compare(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2){
            return true;
        }

        if (len1 < len2){
            return false;
        }

        for(int i=0; i<len1; i++){
            if(nums1[i] > nums2[i]){
                return true;
            }else if(nums1[i] < nums2[i]){
                return false;
            }
        }
        return true;
    }

    public static String retainKDigits(String num, int k){
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);
            while(stack.size() > 0 && stack.size()+num.length()-i > k && stack.peekLast() > ch){
                stack.removeLast();
            }
            stack.addLast(ch);
        }
        int size = stack.size();
        for(int i=0; i < size-k;i++){
            stack.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean zeroLeading = true;
        for(char ch : stack){
            if(zeroLeading && ch =='0')continue;
            zeroLeading = false;
            sb.append(ch);
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] maxRet = null;
        int len1 = nums1.length;
        int len2 = nums2.length;

        for(int i=0; i<= len1;i++){
            for(int j=0; j<=len2;j++){
                if(i+j==k){
                    int[] ret1 = findMaxNumber(nums1,i);
                    int[] ret2 = findMaxNumber(nums2,j);
                    int[] ret = merge(ret1, ret2);
                    if(maxRet == null){
                        maxRet = ret;
                    }else{
                        if(compare(ret, maxRet)){
                            maxRet = ret;
                        }
                    }
                }
            }
        }
        return maxRet;
    }
    public static void main(String[] args){
        //System.out.println(getNoRepeatedSubstring("abcd"));
        char ch1 = 'a';
        char ch2 = 'b';
        System.out.println(ch1 < ch2);

       /* ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        *//*for(String str : list){
            if(str.equals("1")){
                list.remove(str);
            }
        }*//*
        System.out.println(list.toString());
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            if(s.equals("2")){
                iterator.remove();
            }
        }
        System.out.println(list.toString());*/

       /* System.out.println(retainKDigits("1111111",4));
        int[] ret = new int[10];
        System.out.println(ret.length);*/
       int[] nums1 = {6,7};
       int[] nums2 = {6,0,4};
      // maxNumber(nums1,nums2,5);
        //Math.
        //int s= Math.sqrt(1);
    }
}
