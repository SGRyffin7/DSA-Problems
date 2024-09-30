package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/valid-anagram/
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;
        if(s.isEmpty()) return false;

        int[] alpha = new int[26];

        for (int i = 0; i<s.length(); i++) {
            alpha[s.charAt(i)-97]++;
            alpha[t.charAt(i)-97]--;
        }

        for (int count: alpha) {
            if(count != 0) return false;
        }
        return true;
    }
}
