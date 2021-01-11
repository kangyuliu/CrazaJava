package com.company;

public class Solution {
    public static int[] sortArray(int[] nums){
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int index = parttion(nums, left, right);
        quickSort(nums, left, index-1);
        quickSort(nums, index+1, right);
    }

    private static int parttion(int[] nums, int left, int right){
        //以右边数作为基准，小于基准的数排到左侧，大于基准的数排到右侧
        int povit = nums[right];
        int index = left;
        for(int i=left; i<right; i++){
            if(nums[i] < povit){
                swap(nums, i, index);
                index++;
            }
        }
        //将基准换到中间
        swap(nums, index, right);
        return index;
    }

    private static void swap(int[] nums , int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public int[] mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }


    private void mergeSort(int[] nums, int left ,int right){
        if(left>=right) return;
        int mid = (left+right)/2;
        mergeSort(nums,left, mid);
        mergeSort(nums,mid+1, right);
        merge(nums,left,mid,right);
    }

    public void merge(int[] nums, int left, int mid, int right){
        int len = right-left+1;
        int[] tmpNums = new int[len];
        int i=left;
        int j=mid+1;
        int index = 0;
        while(i<=mid && j<=right){
            if(nums[i] < nums[j]){
                tmpNums[index++] = nums[i++];
            }else {
                tmpNums[index++] = nums[j++];
            }
        }

        while(i <=mid){
            tmpNums[index++] = nums[i++];
        }
        while(j<=right){
            tmpNums[index++] = nums[j++];
        }

        //copy back
        for(int k=0; k < len; k++){
            nums[left++] = tmpNums[k];
        }
    }


    public int[] insertSort(int[] nums){

        for(int i=1; i < nums.length; i++){
            int cur = nums[i];
            int preIndex = i-1;
            while(preIndex >=0 && nums[preIndex] > cur ){
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = cur;
        }
        return nums;
    }
}