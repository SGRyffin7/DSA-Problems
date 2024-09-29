package com.greygryffin.practice.easy;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/first-unique-character-in-a-string
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacter().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> appeared = new HashMap<>();
        int unique = 0;
        appeared.put(s.charAt(0), 1);
        for (int i=1; i<s.length(); i++) {
            appeared.put(s.charAt(i), appeared.getOrDefault(s.charAt(i), 0)+1);
            while (unique<s.length() && appeared.getOrDefault(s.charAt(unique), 0) > 1) {
                unique++;
            }
        }
        return unique < s.length() ? unique : -1;
    }

}
