package com.greygryffin.practice.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        new PalindromePartitioning().partition("cbbbcc");
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        ArrayList<String> allChar = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            allChar.add(String.valueOf(s.charAt(i)));
        }
        result.add(allChar);

        partition(allChar, result);

        return result;
    }

    private void partition(List<String> parent, List<List<String>> result) {
        for(int i=0; i<parent.size()-1; i++){
            if(makesPalindrome(parent.get(i), parent.get(i+1))){
                ArrayList<String> child = new ArrayList<>(parent);
                child.remove(i);
                child.remove(i);
                child.add(i, parent.get(i)+parent.get(i+1));
                addIfNotThere(result, child);
                partition(child, result);
            }
        }
        for (int i = 0; i < parent.size() - 2; i++) {
            if(makesPalindrome(parent.get(i), parent.get(i+2))){
                ArrayList<String> child = new ArrayList<>(parent);
                child.remove(i);
                child.remove(i);
                child.remove(i);
                child.add(i, parent.get(i)+parent.get(i+1)+parent.get(i+2));
                addIfNotThere(result, child);
                partition(child, result);
            }
        }
    }

    public boolean makesPalindrome(String fr, String sec) {
        if(fr.length() != sec.length()) return false;
        for(int i=0; i<fr.length(); i++){
            if(fr.charAt(i) != sec.charAt(sec.length()-1-i)) return false;
        }
        return true;
    }
    public void addIfNotThere(List<List<String>> result, List<String> child){
        for (List<String> strings : result) {
            boolean contained = true;
            if (strings.size() == child.size()) {
                for (int j = 0; j < strings.size(); j++) {
                    if (!strings.get(j).equals(child.get(j))) {
                        contained = false;
                        break;
                    }
                }
                if (contained)
                    return;
            }
        }
        result.add(child);
    }

}
