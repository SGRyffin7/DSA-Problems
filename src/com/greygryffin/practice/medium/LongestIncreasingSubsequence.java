package com.greygryffin.practice.medium;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length-1];
        int max = 1;
        for(int i=nums.length-1; i>=0; i--) {
            max = Math.max(max, lis(nums, i, dp));
        }
        return max;
    }
    public int lis(int[] ar, int i, int[] dp) {
        if(i==ar.length-1) return 1;
        if(dp[i] != 0) return dp[i];
        int max = 1;
        for(int j = i+1; j<ar.length; j++) {
            if(ar[i]<ar[j])
                max = Math.max(max, 1+lis(ar, j, dp));
        }
        dp[i] = max;
        return max;
    }
}
