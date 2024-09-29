package com.greygryffin.practice.easy;

import com.greygryffin.practice.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class InorderTraversal {

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

        InorderTraversal test = new InorderTraversal();
        test.tryTwo(one);
    }

    public List<Integer> iterativeInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode!=null) {
            while (currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }

    public List<Integer> recursiveInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        if(root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        if(root.left != null)
            result.addAll(recursiveInorderTraversal(root.left));
        result.add(root.val);
        if(root.right != null)
            result.addAll(recursiveInorderTraversal(root.right));

        return result;

    }

    private List<Integer> tryTwo(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        TreeNode currNode = root;

        while(!stack.isEmpty() || currNode != null){
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }
            TreeNode top = stack.pop();
            result.add(top.val);
            if(top.right!= null) {
                currNode = top.right;
            }
        }

        return result;

    }

}
