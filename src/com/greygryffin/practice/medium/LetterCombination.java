package com.greygryffin.practice.medium;

import java.util.*;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombination {
    public static void main(String[] args) {
        new LetterCombination().letterCombinations("23");
    }
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        Map<Character, List<Character>> keypadMap = new HashMap<Character, List<Character>>();
        keypadMap.put('2', List.of('a', 'b', 'c'));
        keypadMap.put('3', List.of('d', 'e', 'f'));
        keypadMap.put('4', List.of('g', 'h', 'i'));
        keypadMap.put('5', List.of('j', 'k', 'l'));
        keypadMap.put('6', List.of('m', 'n', 'o'));
        keypadMap.put('7', List.of('p', 'q', 'r', 's'));
        keypadMap.put('8', List.of('t', 'u', 'v'));
        keypadMap.put('9', List.of('w', 'x', 'y', 'z'));

        ArrayList<String> result = new ArrayList<String>();

        for (Character ch : keypadMap.get(digits.charAt(0))) {
            result.add(String.valueOf(ch));
        }

        for (int i = 1; i < digits.length(); i++) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (Character che : keypadMap.get(digits.charAt(i))) {
                for (int j=0; j<result.size(); j++) {
                    tmp.add(j,result.get(j) + che);
                }
            }
            result = tmp;
        }


        return result;
    }
}
