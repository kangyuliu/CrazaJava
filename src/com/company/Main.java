package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //StringBuffer
        //StringBuilder
        //Math
    }

    public static int getKth(int[] nums, int k){

        int left = 0;
        int right = nums.length-1;
        int index = parttion(nums, left, right);
        while(index != k-1){
            if(index > k-1){
                right = index-1;
            }else {
                left = index+1;
            }
            index = parttion(nums, left, right);
        }
        return nums[index];
    }

    static int parttion(int[] nums, int left, int right){
        int povit = nums[right];
        int index = left;
        for(int i=left; i< right; i++){
            if(nums[i] < povit){
                swap(nums,i, index);
                index++;
            }
        }
        swap(nums,index, right);
        return index;
    }

    static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
