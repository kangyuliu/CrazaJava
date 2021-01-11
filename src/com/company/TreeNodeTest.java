package com.company;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}


public class TreeNodeTest {

    public static List<Integer> postTravel(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        TreeNode pre = root;
        while(!stack.isEmpty()){
            TreeNode top = stack.peekLast();
            if((top.left == null && top.right == null) || top.left == pre || top.right == null){
                list.add(top.val);
                stack.pollLast();
                pre = top;
            }else {
                if(top.right != null){
                    stack.addLast(top.right);
                }
                if(top.left != null){
                    stack.addLast(top.left);
                }
            }
        }
    }

    public static List<Integer> preTravel(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                list.add(root.val);
                stack.addLast(root);
                root = root.left;
            }
            TreeNode top = stack.pollLast();
            root = top.right;
        }
        return list;
    }

    public static boolean isBST(TreeNode root){
        if(root == null) return true;
        LinkedList<TreeNode> stack = new LinkedList<>();
        double preVal = Double.MAX_VALUE;

        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.addLast(root);
                root = root.left;
            }
            TreeNode top = stack.pollLast();
            if(top.val <= preVal){
                return false;
            }
            preVal = top.val;
            root = top.right;
        }
        return true;
    }

    public static TreeNode mirror(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
        return root;
    }

    boolean helper(TreeNode root, Integer lower, Integer upper){
        if(root == null) return true;
        int val = root.val;
        if(lower != null && val <= lower){
            return false;
        }
        if(upper != null && val >= upper){
            return false;
        }
        if(!helper(root.left, lower, val)){
            return false;
        }
        if(!helper(root.right,val, upper)){
            return false;
        }
        return true;
    }

    TreeNode buildTree(int[] preOrder, int[] midOrder){
        if(preOrder.length != midOrder.length) return null;
        if (preOrder.length <= 0) return null;
        int len = preOrder.length;
        int rootVal = preOrder[0];
        int index = 0;
        while (midOrder[index] != rootVal){
            index++;
        }
        int[] leftPreOrder = new int[index];
        int[] leftMidOrder = new int[index];
        int[] rightPreOrder = new int[len-1-index];
        int[] rightMidOrder = new int[len-1-index];
        for(int i=0; i< index; i++){
            leftPreOrder[i] = preOrder[i+1];
            leftMidOrder[i] = midOrder[i];
        }

        for(int i=0; i<len-1-index; i++){
            rightPreOrder[i] = preOrder[index+1+i];
            rightMidOrder[i] = midOrder[index+1+i];
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(leftPreOrder, leftMidOrder);
        root.right = buildTree(rightPreOrder, rightMidOrder);
        return root;
    }

    List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i< size ;i++){
                TreeNode node = queue.pollFirst();
                if(ret.size() %2 ==0){
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            //ReentrantLock
            //Thread
            //LinkedHashMap
            //TreeSet
            //Thread
            //Callable
            ret.add(list);
        }
        return ret;
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        /*List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            TreeNode node = stack.pollLast();
            ret.add(node.val);
            root = node.right;
        }
        return ret;*/
        //ConcurrentHashMap
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.toArray();
        stack.addLast(root);
        TreeNode pre = root;
        while(!stack.isEmpty()){
            TreeNode node = stack.peekLast();
            while(node.left != null && node.left != pre){
                stack.addLast(node.left);
                node = node.left;
            }
            ret.add(node.val);
            stack.pollLast();
            pre = node;
            if(node.right != null){
                stack.addLast(node.right);
            }
        }
        return ret;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inorderTraversal(root);
    }

    //quick sort
    public static void quickSort(int[] nums){
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int index = parttion(nums, left, right);
        quickSort(nums,left, index-1);
        quickSort(nums, index+1, right);
    }

    public static int parttion(int[] nums, int left, int right){
        //选择最右端数作为基准
        int povit = nums[right];
        int index = left;
        for(int i=0; i < right; i++){
            if(nums[i] > povit){
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index, right);
        return index;
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //merge sort
    public static void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length-1);
    }

    public static void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = (left+right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right){
        int len = right-left+1;
        int[] tmp = new int[len];
        int index = 0;
        int i = left;
        int j = mid+1;
        while(i <= mid && j<=right){
            if(nums[i] < nums[j]){
                tmp[index++] = nums[i++];
            }else {
                tmp[index++] = nums[j++];
            }
        }

        while (i <= mid){
            tmp[index++] = nums[i++];
        }

        while (j <= right){
            tmp[index++] = nums[j++];
        }

        for(int k=0; k < tmp.length; k++){
            nums[left+k] = tmp[k];
        }
    }

    public static void insertSort(int[] nums){
        for(int i=1; i < nums.length; i++){
            int j = i-1;
            while(j >= 0 && nums[i] < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = nums[i];
        }
    }
}
