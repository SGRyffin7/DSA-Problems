package com.greygryffin.practice.medium;

/*
https://leetcode.com/problems/container-with-most-water/
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int max = 0;
        while(start < end) {
            int area = (end-start)*Math.min(height[start], height[end]);
            max = Math.max(max, area);
            if(height[start] < height[end])
                start++;
            else if(height[start] > height[end])
                end--;
            else {
                start++;
                end--;
            }
        }
        return max;
    }
}
