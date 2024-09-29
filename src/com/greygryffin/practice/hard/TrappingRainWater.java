package com.greygryffin.practice.hard;

/*
https://leetcode.com/problems/trapping-rain-water/
*/
public class TrappingRainWater {

    public int calculateTrapped(int[] height) {

        int[] toLeft = new int[height.length];
        int[] toRight = new int[height.length];
        int maxLeft = -1;
        int maxRight = -1;

        for(int i = 0; i<height.length; i++) {
            maxLeft = Integer.max(height[i], maxLeft);
            toLeft[i] = maxLeft;
        }

        for(int i=height.length-1; i>=0; i--) {
            maxRight = Integer.max(height[i], maxRight);
            toRight[i] = maxRight;
        }

        int trapped = 0;

        for(int i=0; i<height.length; i++) {
            trapped += Integer.min(toLeft[i], toRight[i]) - height[i];
        }

        return trapped;

    }

}
