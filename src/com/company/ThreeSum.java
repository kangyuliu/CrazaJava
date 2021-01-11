package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length;i++){

        }


        return ret;
    }

    List<Integer> twoSum(int[] nums, int start, int target){
        List<Integer> ret = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=start; i< nums.length;i++){
            if(map.containsKey(target - nums[i])){
                ret.add(target -nums[i]);
                ret.add(nums[i]);
                return ret;
            }else {
                map.put(nums[i],i);
            }
        }
        return  ret;
    }
}
