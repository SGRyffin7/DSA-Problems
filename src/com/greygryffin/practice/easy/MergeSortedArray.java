package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] one = {-1,0,0,3,3,3,0,0,0};
        int[] two = {1,2,2};
        System.out.println();merge(one, 6, two,3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(j>=0 && i>=0)
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        while(j>=0)
            nums1[k--] = nums2[j--];
    }
}
