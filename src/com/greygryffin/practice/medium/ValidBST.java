package com.greygryffin.practice.medium;

import com.greygryffin.practice.TreeNode;
import com.sun.source.tree.Tree;

/*
https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val >= max && root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
