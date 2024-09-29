package com.greygryffin.practice.medium;

import com.greygryffin.practice.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree {
    public static void main(String[] args) {
//        int[] pre = {3,9,20,15,7};
//        int[] in = {9,3,15,20,7};
        int[] pre = {-1};
        int[] in = {-1};

        System.out.println(new BuildTree().buildTree(pre, in));
        System.out.println(new BuildTree().tryTwo(pre, in));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder,  0, 0, inorder.length - 1, inorderMap);
    }

    public TreeNode buildTree(int[] preOrder, int preStart, int inorderStart, int inorderEnd, Map<Integer, Integer> inorderMap) {
        TreeNode root = new TreeNode(preOrder[preStart]);
        if (inorderStart == inorderEnd)
            return root;
        int inorderPosition = inorderMap.get(root.val);
        boolean leftExists = inorderPosition>inorderStart;
        boolean rightExists = inorderPosition<inorderEnd;
        if(leftExists && rightExists) {
            //both tree exists
            root.left = buildTree(preOrder,  preStart+1,  inorderStart, inorderPosition-1, inorderMap);
            root.right = buildTree(preOrder, preStart + inorderPosition - inorderStart +1, inorderPosition+1, inorderEnd, inorderMap);
        } else if(leftExists) {
            //only left exists
            root.left = buildTree(preOrder,  preStart+1, inorderStart, inorderPosition-1, inorderMap);
        } else {
            //only right exists
            root.right = buildTree(preOrder, preStart+1, inorderPosition+1, inorderEnd, inorderMap);
        }
        return root;
    }

    private TreeNode tryTwo(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length==0 || inorder == null || inorder.length==0) return null;
        HashMap<Integer, Integer> inValueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inValueIndexMap .put(inorder[i], i);
        }
        return tryTwoRec(preorder,  0, 0, inorder.length-1, inValueIndexMap);
    }

    private TreeNode tryTwoRec(int[] preOrder, int preStart, int inStart, int inEnd, HashMap<Integer, Integer> inValueIndexMap) {
        TreeNode node = new TreeNode(preOrder[preStart]);

        int inOrderPos = inValueIndexMap.get(preOrder[preStart]);

        boolean leftExists = inOrderPos > inStart;
        boolean rightExists = inOrderPos < inEnd;
        if(leftExists && rightExists) {
            node.left = tryTwoRec(preOrder, preStart + 1, inStart, inOrderPos - 1, inValueIndexMap);
            node.right = tryTwoRec(preOrder, preStart+inOrderPos-inStart+1, inOrderPos+1, inEnd, inValueIndexMap);
        } else if(leftExists) {
            node.left = tryTwoRec(preOrder, preStart+1, inStart, inEnd-1, inValueIndexMap);
        } else if(rightExists){
            node.right = tryTwoRec(preOrder, preStart+1, inStart+1, inEnd, inValueIndexMap);
        }

        return node;
    }
}
