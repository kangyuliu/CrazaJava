package com.company.com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    ListNode sortList(ListNode head, int x){
        if(head == null) return head;
        ListNode dummy1 = new ListNode(0);
        ListNode pre1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode pre2 = dummy2;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            if(cur.val < x){
               pre1.next = cur;

               cur = next;
               pre1=pre1.next;
            }else{
                pre2.next = cur;
                cur = next;
                pre2 = pre2.next;
            }
            //cur = cur.next;
        }
        pre1.next = dummy2.next;
        pre2.next = null;
        return dummy1.next;
    }


    List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrance(nums, 0, res, tmp, used);
        return res;
    }

    void backTrance(int[] nums, int i, List<List<Integer>> res, List<Integer> tmp, boolean[] used){
        res.add(tmp);
        for(int j=i; j < nums.length; j++){
            if(j >0 && nums[j] == nums[j-1] && used[j-1]){
                continue;
            }
            tmp.add(nums[j]);
            used[j] = true;
            backTrance(nums, j+1, res, tmp, used);
            tmp.remove(tmp.size()-1);
            used[j] = false;
        }
    }

}
