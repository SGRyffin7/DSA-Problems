package com.greygryffin.practice.medium;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotated {

    public static void main(String[] args) {
        int[] in = {4,5,6,7,0,1,2};
        new SearchRotated().search(in, 0);
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    int search(int[] nums, int target, int start, int end) {
        if(start>end) return -1;

        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        int mid = (start+end)/2;
        if(nums[mid] == target) return mid;

        if(nums[start]<nums[end] && (target<nums[start]||target>nums[end])) return -1;

        int result1 = search(nums, target, start+1, mid-1);
        if(result1 != -1) return result1;
        return search(nums, target, mid+1, end-1);
    }
}
