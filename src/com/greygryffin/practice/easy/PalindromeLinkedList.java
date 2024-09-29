package com.greygryffin.practice.easy;

import com.greygryffin.practice.ListNode;

import java.util.Stack;

/*
https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,1};
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i< arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;
        if(head.next.next == null) return head.val == head.next.val;

        ListNode walker = head.next;
        ListNode runner = head.next.next;
        head.next = null;
        while (runner.next != null && runner.next.next != null){
            ListNode tmp = walker.next;
            walker.next = head;
            head = walker;
            walker = tmp;
            runner = runner.next.next;
        }

        if(runner.next == null) { //EVEN INDEX, ODD ELEMENTS
            walker = walker.next;
        } else { //ODD INDEX, EVEN ELEMENTS, must go one more step
            ListNode tmp = walker.next;
            walker.next = head;
            head = walker;
            walker = tmp;
        }

        while(walker != null) {
            if (walker.val != head.val) return false;
            walker = walker.next;
            head = head.next;
        }

        //Order of the list is destroyed here. It can be restored too if required while we match the two lists

        return true;
    }
}
