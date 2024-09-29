package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/plus-one/
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = true;

        for(int i = digits.length-1; i>-1; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                carry = false;
                break;
            }
        }

        if(carry) {
            int length = digits.length+1;
            int[] result = new int[length];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
            return digits;
        }
    }
}
