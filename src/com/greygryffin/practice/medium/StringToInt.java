package com.greygryffin.practice.medium;

public class StringToInt {
    public static void main(String[] args) {
        new StringToInt().myAtoi("21474836460");
    }
    public int myAtoi(String s) {
        boolean negative = false;
        boolean clamped = false;
        int number = -1;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(number == -1) {
                if(ch == ' ') {
                    continue;
                }
                if(ch == '-') {
                    negative = true;
                    number = 0;
                    continue;
                }
                if(ch == '+') {
                    number = 0;
                    continue;
                }
                if(isNumeric(ch)) {
                    number = 0;
                }
            }
            if(isNumeric(ch)){
                int prev = number;
                number = (number*10) + (ch-48);
                if(number>99999999 && number/10 != prev || number<0) {
                    clamped = true;
                    break;
                }
            } else {
                break;
            }
        }
        if(number == -1) return 0;
        if(clamped) {
            if(negative)
                return -2147483648;
            else
                return 2147483647;
        }
        if(negative)
            number = number*-1;
        return number;
    }

    boolean isNumeric(char ch) {
        return ch>=48 && ch<=57;
    }
}
