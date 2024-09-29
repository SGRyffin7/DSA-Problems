package com.greygryffin.practice.medium;

public class NeedleHayStack {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        int i =0;
        while (i<haystack.length()-needle.length()) {
            if(haystack.charAt(i) == needle.charAt(0) && haystack.startsWith(needle, i)){
                return i;
            }
            i++;
        }
        return -1;
    }
}
