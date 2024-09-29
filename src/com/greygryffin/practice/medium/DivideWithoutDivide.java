package com.greygryffin.practice.medium;

/*
https://leetcode.com/problems/divide-two-integers/
 */
public class DivideWithoutDivide {
    public static void main(String[] args) {

    }
    public int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(divisor == -1) return -dividend;
        boolean negative = dividend<0 ^ divisor<0;
        if(dividend<0) dividend = -dividend;
        if(divisor<0) divisor = -divisor;
        int q = 0;
        while(dividend >= divisor) {
            dividend -= divisor;
            q++;
        }
        return negative? -q : q;
    }
}
