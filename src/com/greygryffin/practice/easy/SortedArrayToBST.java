package com.greygryffin.practice.easy;

import com.greygryffin.practice.TreeNode;

public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] input = {-10,-3,0,5,9};
        System.out.println(new SortedArrayToBST().sortedArrayToBST(input));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToTree(nums, 0, nums.length-1);
    }

    public TreeNode arrayToTree(int[] nums, int start, int end) {
        TreeNode root = new TreeNode();
        if(start == end) {
            root.val = nums[start];
            return root;
        }

        if(end-1 == start) {
            root.val = nums[end];
            root.left = arrayToTree(nums, start, start);
            return root;
        }

        int mid = (start + end)/2;
        root.val = nums[mid];

        root.left = arrayToTree(nums, start, mid == 0 ? mid : mid-1);
        root.right = arrayToTree(nums, mid+1, end);

        return root;

    }

}
