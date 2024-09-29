package com.greygryffin.practice.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/
 00:54
 */
public class DeepCopyRandom {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(head, new Node(head.val));
        Node headCopy = head;
        while (head != null) {
            Node copy = nodeMap.get(head);

            if(head.random != null) {
                if (!nodeMap.containsKey(head.random))
                    nodeMap.put(head.random, new Node(head.random.val));
                copy.random = nodeMap.get(head.random);
            }

            if(head.next != null) {
                if (!nodeMap.containsKey(head.next))
                    nodeMap.put(head.next, new Node(head.next.val));
                copy.next = nodeMap.get(head.next);
            }

            head = head.next;
        }
        return nodeMap.get(headCopy);
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
