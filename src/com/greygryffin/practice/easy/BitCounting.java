package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/number-of-1-bits/
 */

public class BitCounting {
    public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0) {
            sum += (n&1);
            n = n>>>1;
        }
        return sum;
    }
}
