package com.greygryffin.practice.easy;
/*
https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        new ReverseInteger().reverse(123);
    }
    public int reverse(int x) {
        int reverse = 0;
        boolean negative = x<0;
        if(negative) x*=-1;
        int len = 0;
        int firstDigit = x%10;
        while(x > 0) {
            reverse = reverse*10 + x%10;
            x /= 10;
            len++;
        }
        if(len<9)
            return negative ? reverse*-1 : reverse;
        else if(reverse/((int)Math.pow(10, len-1)) == firstDigit)
            return negative ? reverse*-1 : reverse;
        else
            return 0;
    }
}
