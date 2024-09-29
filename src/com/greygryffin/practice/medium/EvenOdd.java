package com.greygryffin.practice.medium;

import com.greygryffin.practice.ListNode;

/**
 * Leetcode EvenOdd Linked list
 */
public class EvenOdd {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        EvenOdd test = new EvenOdd();
        ListNode head = new ListNode(arr);
        System.out.println(test.oddEvenList(head));
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode next = head.next.next;
        h1.next = null;
        h2.next = null;
        ListNode even = h2;
        boolean odd = true;
        while(next != null) {
            if(odd){
                h1.next = next;
                h1 = h1.next;
                next = next.next;
                h1.next = null;
                odd = false;
            } else {
                h2.next = next;
                h2 = h2.next;
                next = next.next;
                h2.next = null;
                odd = true;
            }

        }
        h1.next = even;

        return head;
    }
}
