package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/move-zeroes/
 */

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    public void moveZeroes(int[] nums) {
        int zeroesStart = -1, zeroesEnd = -1;
        for (int i=0; i<nums.length && zeroesEnd< nums.length-1; i++) {
            if(nums[i] == 0) {
                if(zeroesStart == -1) {
                    zeroesStart = i;
                    zeroesEnd = i;
                } else {
                    zeroesEnd++;
                }
            } else if(zeroesStart != -1) {
                nums[zeroesStart] = nums[i];
                nums[i] = 0;
                zeroesStart++;
                zeroesEnd = i;
            }
        }
    }
}
