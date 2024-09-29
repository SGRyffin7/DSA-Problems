package com.greygryffin.practice.easy;

import com.greygryffin.practice.ListNode;

public class SumOfList {

    public static void main(String[] args) {
        int[] in1 = {9,9,9,9,9,9,9};
        int[] in2 = {9,9,9,9};
        new SumOfList().addTwoNumbers(ListNode.toLinkedList(in1), ListNode.toLinkedList(in2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) return null;
        ListNode r = new ListNode();
        r.val = l1.val + l2.val;
        int carry = 0;
        if(r.val > 9) {
            carry = r.val/10;
            r.val = r.val%10;
        }
        ListNode tail = r;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2!=null){
            ListNode sum = new ListNode();
            sum.val = l1.val + l2.val + carry;
            if(sum.val > 9) {
                carry = sum.val/10;
                sum.val = sum.val%10;
            } else
                carry = 0;
            tail.next = sum;
            tail = sum;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2!=null) {
            tail.next = l2;
        } else if(l1!=null) {
            tail.next = l1;
        }

        while(carry != 0) {
            if(tail.next == null) {
                tail.next = new ListNode(carry);
                break;
            } else {
                tail = tail.next;
                tail.val += carry;
                if(tail.val > 9) {
                    carry = tail.val/10;
                    tail.val %= 10;
                } else {
                    carry = 0;
                }
            }
        }

        return r;
    }
}
