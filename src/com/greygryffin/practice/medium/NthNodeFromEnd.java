package com.greygryffin.practice.medium;

import com.greygryffin.practice.ListNode;

import java.util.List;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class NthNodeFromEnd {
    public static void main(String[] args) {
        int[] inp = {1,2};
        new NthNodeFromEnd().removeNthFromEnd(ListNode.toLinkedList(inp), 1);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n<1) return null;
        ListNode pointer = head, pointerN = head;
        int counter = 0;
        while(pointer!=null) {
            pointer = pointer.next;
            counter++;
            if(counter > n+1)
                pointerN = pointerN.next;
        }

        if(n==counter)
            return head.next;
        else if(pointerN.next.next!= null) {
            pointerN.next = pointerN.next.next;
        } else {
            pointerN.next = null;
        }

        return head;
    }
}
