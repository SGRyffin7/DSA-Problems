package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {

    public static void main(String[] args) {
        new PowerOfThree().isPowerOfThree(9);
    }

    public boolean isPowerOfThree(int n) {
        while(n>=3){
            if(n%3 != 0) return false;
            n = n/3;
        }
        return n==1;
    }
}
