package com.greygryffin.practice.easy;

import com.greygryffin.practice.ListNode;

/*
https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class LinkedListIntersection {

    public static void main(String[] args) {
        ListNode rootA = new ListNode(4);
        rootA.next = new ListNode(1);
        rootA.next.next = new ListNode(8);

        ListNode rootB = new ListNode(5);
        rootB.next = rootA;
//        rootB.next = new ListNode(6);
//        rootB.next.next = new ListNode(1);
//        rootB.next.next.next = new ListNode(1);

//        rootB.next.next.next = rootA.next.next;

//        rootB.next.next.next.next = new ListNode(4);
//        rootB.next.next.next.next.next = new ListNode(5);

        System.out.println(new LinkedListIntersection().getIntersectionNode(rootA, rootB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null) return null;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while(pointerA != pointerB) {
            if(pointerA == null) pointerA = headB;
            if(pointerB == null) pointerB = headA;

            pointerA = pointerA.next;
            pointerB = pointerB.next;


        }
        return pointerA;
    }

    private ListNode tryTwo(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        int nullCounter = 0;
        while(a != b) {
            if(a.next == null) {
                a = headB;
                nullCounter++;
                if(nullCounter == 2){
                    return null;
                }
            } else {
                a = a.next;
            }
            b = b.next == null ? headA : b.next;
        }
        return a;
    }
}
