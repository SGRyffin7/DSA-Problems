package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/excel-sheet-column-number/
 */

public class ExcelColumnTile {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for(int i=0; i<columnTitle.length(); i++) {
            int current = columnTitle.charAt(i)-64;
            result += Math.pow(26, columnTitle.length() -1 - i)*current;
        }
        return result;
    }
}
