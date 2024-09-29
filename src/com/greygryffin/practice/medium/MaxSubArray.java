package com.greygryffin.practice.medium;
/*
https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] in = {8,-19,5,-4,20};
        new MaxSubArray().mxSubArray(in);
    }

    //Incomplete
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int subEnd = 0, maxSum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(maxSum<0){
                if(nums[i]>maxSum){
                    maxSum = nums[i];
                    subEnd = i;
                }
            } else {
                if (nums[i] < 0) continue;
                if (subEnd == i - 1) {
                    maxSum += nums[i];
                } else {
                    int deltaSum = 0;
                    for (int j = subEnd + 1; j <= i; j++) {
                        deltaSum += nums[j];
                    }
                    if (deltaSum > 0) {
                        maxSum += deltaSum;
                    }
                    if (maxSum < nums[i]){
                        maxSum = nums[i];
                    }
                }
                subEnd = i;
            }
        }
        return maxSum;
    }

    public int mxSubArray(int[] A) {
        int max = A[0];

        for(int i=1; i<A.length; i++) {
            A[i] = A[i] + (A[i-1] > 0 ? A[i-1] : 0);
            max = Math.max(max, A[i]);
        }

        return max;
    }
}
