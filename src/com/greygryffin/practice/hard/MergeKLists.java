package com.greygryffin.practice.hard;

import com.greygryffin.practice.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> {
            if(o1.val > o2.val)
                return 1;
            else if(o1.val < o2.val)
                return -1;
            return 0;
        });

        if(lists.length < 1) return null;

        for (ListNode node: lists) {
            if(node!=null) minHeap.add(node);
        }

        ListNode merged = minHeap.poll();
        ListNode head = merged;

        if(merged != null && merged.next != null) {
                minHeap.add(merged.next);
                merged.next = null;
        }

        while(!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            merged.next = current;
            merged = merged.next;
            if(current.next != null) {
                minHeap.add(current.next);
                current.next = null;
            }
        }

        return head;
    }
}
