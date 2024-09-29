package com.greygryffin.practice.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class ConnectLevel {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int nextCount = 1;
        while (!q.isEmpty()) {
            int c=1;
            while (c<=nextCount) {
                Node n = q.poll();
                if(c==nextCount){
                    n.next = null;
                } else {
                    n.next = q.peek();
                }
                if(n.left!=null){
                    q.offer(n.left);
                    q.offer(n.right);
                }
                c++;
            }
            nextCount *= 2;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
