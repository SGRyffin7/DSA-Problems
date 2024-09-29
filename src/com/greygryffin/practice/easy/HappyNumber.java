package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/happy-number/
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        new HappyNumber().isHappy(7);
    }

    public boolean isHappy(int n) {
        if(n <= 0) return false;
        long num = n;
        Set<Long> pastSums = new HashSet<>();
        while(num!=1) {
            if(pastSums.contains(num))
                return false;
            else
                pastSums.add(num);
            num = getHappySum(num);
        }
        return true;
    }

    private long getHappySum(long n) {
        long sum = 0;
        while(n!=0) {
            byte digit = (byte) (n%10);
            sum += digit*digit;
            n = n/10;
        }
        return sum;
    }
}
