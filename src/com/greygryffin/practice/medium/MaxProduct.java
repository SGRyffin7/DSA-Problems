package com.greygryffin.practice.medium;
/*
https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProduct {
    public void maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int curProduct = Integer.MIN_VALUE;
        int maxLastAt = 0;
        int curLastAt = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i]<1){
                if(maxProduct < nums[i]){
                    curProduct = maxProduct = nums[i];
                    curLastAt = maxLastAt = i;
                }
            } else {
                if(maxProduct<1){
                    curProduct = maxProduct = nums[i];
                    curLastAt = maxLastAt = i;
                } else {
                    if(maxLastAt==i-1) {
                        curLastAt = maxLastAt = i;
                        maxProduct = curProduct = maxProduct*nums[i];
                    } else {
                        curLastAt = i;

                    }
                }
            }
        }
    }
}
