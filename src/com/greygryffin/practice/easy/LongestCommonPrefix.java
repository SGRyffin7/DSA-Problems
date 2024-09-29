package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/longest-common-prefix/
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        if(strs.length == 1) return strs[0];

        StringBuilder strBuff = new StringBuilder();

        for (int i = 0; i< strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);
            for(int j = 1; j< strs.length; j++) {
                try{
                    if(strs[j].charAt(i) != currentChar)
                        return strBuff.toString();
                } catch (StringIndexOutOfBoundsException ex) {
                    return strBuff.toString();
                }
            }
            strBuff.append(currentChar);
        }

        return strBuff.toString();
    }
}
