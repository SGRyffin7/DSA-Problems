package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/sort-colors
 */
public class SortColors {
    public void sortColorsCounter(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == 0)
                count0++;
            else if (num == 1)
                count1++;
            else if (num == 2)
                count2++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (count0 > 0) {
                nums[i] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[i] = 1;
                count1--;
            } else if (count2 > 0) {
                nums[i] = 2;
                count2--;
            }
        }
    }

    public void sortColors(int[] nums) {
        int pivot0 = 0;
        int pivot1 = 0;
        int pivot2 = nums.length - 1;
        int t = 0;
        while(pivot1 < pivot2) {
            if(nums[pivot1] == 0) {
                t = nums[pivot0];
                nums[pivot0] = nums[pivot1];
                nums[pivot1] = t;
                pivot0++;
                pivot1++;
            } else if(nums[pivot1] == 1) {
                pivot1++;
            } else if(nums[pivot1] == 2) {
                t = nums[pivot2];
                nums[pivot2] = nums[pivot1];
                nums[pivot1] = t;
                pivot2--;
            }
        }
    }
}
