package com.greygryffin.practice.hard;

/*
https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        int i =0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]<0) nums[j] = 0;
        }
        while(i<nums.length) {
            if(nums[i]>0 && nums[i]<=nums.length) {
                int temp = nums[i];
                nums[i] = nums[temp-1] == -1 ? 0 : nums[temp-1];
                nums[temp-1] = -1;
            }
            if(nums[i] <= 0 || nums[i] > nums.length)
                i++;
        }

        for (i=0; i<nums.length; i++) {
            if(nums[i] != -1)
                break;
        }

        return i+1;
    }
}
