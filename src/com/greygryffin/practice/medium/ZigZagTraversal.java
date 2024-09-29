package com.greygryffin.practice.medium;

import com.greygryffin.practice.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagTraversal {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        five.right = eight;
        six.right = nine;

        ZigZagTraversal test = new ZigZagTraversal();
        System.out.println(test.tryTwo(one));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean left = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> newList = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(left)
                    newList.add(node.val);
                else
                    newList.add(0, node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }
            res.add(newList);
            left = !left;
        }
        return res;
    }

    private List<List<Integer>> tryTwo (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rtl = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(rtl ? list.size() : 0, node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            result.add(list);
            rtl = !rtl;
        }

        return result;
    }
}
