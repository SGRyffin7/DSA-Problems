package com.greygryffin.practice;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}

    public ListNode(int[] arr){
        if(arr == null || arr.length == 0)  return;
        this.val = arr[0];
        ListNode curr = this;
        for (int i=1; i<arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
    }
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode toLinkedList(int[] arr) {
        if(arr==null) return null;
        if(arr.length < 1) return new ListNode();
        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for (int i = 1; i< arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(val));
        if(next != null) {
            sb.append("->");
            sb.append(next);
        }
        return sb.toString();
    }
}
