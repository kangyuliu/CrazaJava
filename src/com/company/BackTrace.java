package com.company;

import java.util.List;

public class BackTrace {

    void backTrace(int[] nums, int i, List<Integer> tmp, List<List<Integer>> res){
        res.add(tmp);
        for(int j=i; j < nums.length; j++){
            tmp.add(nums[j]);
            backTrace(nums,j+1, tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }


}
