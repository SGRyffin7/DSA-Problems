package com.greygryffin.practice.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringNoRepeat {

    public static void main(String[] args) {
        new LongestSubstringNoRepeat().tryTwo("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        Map<Character, Integer> inCurrent = new HashMap<>();
        int curHead = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if(inCurrent.containsKey(s.charAt(i))) {
                int inter = inCurrent.get(s.charAt(i));
                while(curHead <= inter){
                    inCurrent.remove(s.charAt(curHead));
                    curHead++;
                }
                curHead = inter+1;
            }
            inCurrent.put(s.charAt(i), i);
            if(i-curHead+1 > maxLength)
                maxLength = i-curHead+1;
        }
        return maxLength;
    }

    private int tryTwo(String s) {
        if(s== null || s.isEmpty()) return 0;
        int maxLength = 1;
        HashSet<Character> charSet = new HashSet<>();
        charSet.add(s.charAt(0));
        StringBuilder currentString = new StringBuilder(s.substring(0, 1));

        for(int i=1; i<s.length(); i++) {
            if(charSet.contains(s.charAt(i))) {
                int index = currentString.indexOf(s.substring(i, i+1));
                for(int j = 0; j<= index; j++){
                    charSet.remove(currentString.charAt(0));
                    currentString.deleteCharAt(0);
                }
            }

            currentString.append(s.charAt(i));
            charSet.add(s.charAt(i));
            if(currentString.length() > maxLength) {
                maxLength = currentString.length();
            }
        }

        return maxLength;
    }
}
