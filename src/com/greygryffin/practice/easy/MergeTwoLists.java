package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        head.next = null;

        ListNode tail = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = tail.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = tail.next;
            }
            tail.next = null;
        }

        if(list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
