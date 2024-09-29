package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        int result = 0;
        int lastValue = getValue(s.charAt(s.length()-1));
        int currentValue = 0;

        //loop from end to start
        for (int i = s.length()-1; i >=0; i--){
            currentValue = getValue(s.charAt(i));
            if(currentValue < lastValue)
                result -= currentValue;
            else {
                result += currentValue;
                lastValue = currentValue;
            }

        }

        return result;

    }

    public int getValue(char ch) {
        return switch (ch) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            default -> 1;
        };
    }
}
