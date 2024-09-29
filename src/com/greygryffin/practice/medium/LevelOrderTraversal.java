package com.greygryffin.practice.medium;

import com.greygryffin.practice.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int nextLevelSize = 1;
        while(!q.isEmpty()) {
            int curSize = nextLevelSize;
            nextLevelSize = 0;
            List<Integer> newList = new ArrayList<>();
            while (curSize > 0) {
                TreeNode node = q.poll();
                curSize--;
                newList.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                    nextLevelSize++;
                }
                if(node.right != null) {
                    q.offer(node.right);
                    nextLevelSize++;
                }
            }
            res.add(newList);
        }
        return res;
    }
}
