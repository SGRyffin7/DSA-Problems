package com.greygryffin.practice.medium;
/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ar = {-1, -1};
        searchRange(nums, target, 0, nums.length-1, ar);
        return ar;
    }

    void searchRange(int[] nums, int target, int start, int end, int[] sol) {
        if(nums[start] == target) {
            sol[0] = sol[0] == -1 ? start : Math.min(start, sol[0]);
            sol[1] = Math.max(start, sol[1]);
        }
        if(nums[end] == target) {
            sol[0] = sol[0] == -1 ? end : Math.min(end, sol[0]);
            sol[1] = Math.max(end, sol[1]);
        }
        if(nums[start] == target && nums[end]==target) return;

        int mid = (start+end)/2;
        if(nums[mid] < target) {
            searchRange(nums, target, mid, end-1, sol);
        } else if (nums[mid] > target) {
            searchRange(nums, target, start+1, mid, sol);
        } else {
            searchRange(nums, target, mid, end-1, sol);
            searchRange(nums, target, start+1, mid, sol);
        }
    }
}
