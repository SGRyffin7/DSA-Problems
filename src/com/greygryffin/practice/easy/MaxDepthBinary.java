package com.greygryffin.practice.easy;

import com.greygryffin.practice.TreeNode;

public class MaxDepthBinary {
    public int recursiveMaxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return Math.max(recursiveMaxDepth(root.left), recursiveMaxDepth(root.right))+1;
    }

//    public int maxDepth() {
        //BFS, queue holds all elements of same level at same time.
//    }
}
