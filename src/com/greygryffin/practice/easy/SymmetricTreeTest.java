package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/symmetric-tree/
 */

import com.greygryffin.practice.TreeNode;

public class SymmetricTreeTest {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirrored(root.left, root.right);
    }

    public boolean isMirrored(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == right;
        if(left.val != right.val)
            return false;
        if(left.left == null && left.right == null && right.left == null && right.right == null)
            return true;
        return isMirrored(left.left, right.right) && isMirrored(left.right, right.left);
    }
}
