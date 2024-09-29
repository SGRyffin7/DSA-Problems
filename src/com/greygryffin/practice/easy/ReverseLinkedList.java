package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/reverse-linked-list/
 */

import com.greygryffin.practice.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode head2 = head.next;
        head.next = null;
        while(head2 != null) {
            ListNode tmp = head2.next;
            head2.next = head;
            head = head2;
            head2 = tmp;
        }
        return head;
    }
}
