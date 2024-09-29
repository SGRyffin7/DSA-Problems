package com.greygryffin.practice.medium;

import com.greygryffin.practice.TreeNode;

public class BasicCalculatorII {
    public int evaluate(TreeNode root, TreeNode p, TreeNode q) {

        //DFS
        //Save Stack
        //Navigate till different nodes are reached
        int[] nums = {1, 2,3};
        int sum = (nums.length * (nums.length -1)) /2 ;
        for (int i = 0; i<nums.length; i++) {
            sum-=nums[i];
        }
        return -1*sum;

    }
}
