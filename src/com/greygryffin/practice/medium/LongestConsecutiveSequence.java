package com.greygryffin.practice.medium;

import java.util.HashSet;

/*
https://leetcode.com/problems/longest-consecutive-sequence/
18:10
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums){
            set.add(n);
        }
        for (int n: nums) {
            if(!set.contains(n+1)){
                int curLength = 1;
                while(set.contains(n-1)){
                    curLength++;
                    n--;
                }
                maxLength = Math.max(curLength, maxLength);
            }
        }
        return maxLength;
    }
}
