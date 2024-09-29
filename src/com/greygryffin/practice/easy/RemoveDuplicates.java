package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int lastUnique = 0;

        for(int i = 0; i< nums.length; i++) {
            if(nums[lastUnique] != nums[i]) {
                lastUnique += 1;
                nums[lastUnique] = nums[i];
            }
        }

        return lastUnique+1;
    }
}
