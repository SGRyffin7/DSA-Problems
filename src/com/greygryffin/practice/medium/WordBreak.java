package com.greygryffin.practice.medium;

import java.util.*;

/*
https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    public static void main(String[] args) {
        String input = "catsandog";
        List<String> words = List.of("cats","dog","sand","and","cat");
        new WordBreak().wordBreak(input, words);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> setDict = new HashSet<>(wordDict);
        HashMap<Integer, Boolean> breakable = new HashMap<>();
        wordBreak(s, setDict, 0, breakable);
        return breakable.get(0);
    }

    public boolean wordBreak(String s, Set<String> dict, int start, Map<Integer, Boolean> breakable){
        if(start > s.length()-1) return true;
        if(breakable.containsKey(start)) return breakable.get(start);
        for(int i=1; start+i<=s.length(); i++){
            int endIndex = start+i;
            boolean contains;
            if(endIndex >= s.length())
                contains = dict.contains(s.substring(start));
            else
                contains = dict.contains(s.substring(start, start+i));
            if(contains){
                if(wordBreak(s, dict, start+i, breakable)){
                    breakable.put(start, true);
                    return true;
                }
            }
        }
        breakable.put(start, false);
        return false;
    }
}
