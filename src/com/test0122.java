package com;

public class test0122 {


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val =val;
        }
    }


    /*

    [A , B ,D ,E ,C ,F,G] 前
    [D, E, B, A, F, C, G] 中


     */

    TreeNode buildTreeNode(int[] preOrder,  int[] midOrder){
        if(preOrder.length != midOrder.length) return null;
        int len = preOrder.length;
        int rootVal = preOrder[0];//root

        int index = 0;
        for(; index <len; index++){
            if(midOrder[index] == rootVal){
                break;
            }
        }
        int[] leftPre = new int[index];
        int[] leftMid = new int[index];
        int[] rightPre = new int[len-index-1];
        int[] rightMid = new int[len-index-1];

        for(int i=0; i < index; i++){
            leftPre[i] = preOrder[i+1];
        }
        for(int i=0; i <index; i++){
            leftMid[i] = midOrder[i];
        }
        for(int i=0; i< len-index-1; i++){
            rightPre[i] = preOrder[index+i+1];
        }
        for(int i=0; i < len-index-1;i++){
            rightMid[i] = midOrder[index+i+1];
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeNode(leftPre,leftMid);
        root.right = buildTreeNode(rightPre, rightMid);
        return  root;
    }

}
