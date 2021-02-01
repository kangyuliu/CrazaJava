package com;

public class HeapSort {
    //升序--大顶堆


    void headSort(int[] nums){
        buildHeap(nums);
        int size = nums.length;
        while(size >1){
            swap(nums, 0, size-1);
            size--;
            heapfy(nums,0,size);
        }
    }

    //下沉
    void heapfy(int[] nums, int index, int size){
        int left = 2*index +1;
        int right = 2*index+2;
        int maxIndex = index;
        if(left < size && nums[maxIndex] < nums[left]){
            maxIndex = left;
        }
        if(right <size && nums[maxIndex] < nums[right]){
            maxIndex = right;
        }
        if(maxIndex != index){
            swap(nums, index, maxIndex);
            heapfy(nums, maxIndex,size);
        }
    }

    void buildHeap(int[] nums){
        int size = nums.length;
        for(int i=size-1/2; i>=0;i--){
            heapfy(nums,i,size);
        }
    }

    void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
