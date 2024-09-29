package com.greygryffin.practice.easy;

import java.util.Stack;

/*
https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("adam"));
    }
    public String longestPalindrome(String s) {
        if(s==null) return null;
        if(s.length() == 0) return "";
        //Stores Valid Palindromes starting with all palindromes of length 1, Basically DFS
        Stack<Palindrome> validPalindromes = new Stack<>();
        Palindrome max = new Palindrome(0, -1);
        for (int i=0; i< s.length(); i++) {
            validPalindromes.push(new Palindrome(i, i));
        }
        while(!validPalindromes.isEmpty()) {
            Palindrome cp = validPalindromes.pop();
            if(max.end-max.start+1 < cp.end-cp.start+1) max = cp;
            if(max.end-max.start+1 == s.length()) break; // If max length of the String is reached no need to check further
            if(cp.start>0 && cp.end<s.length()-1 && s.charAt(cp.start-1) == s.charAt(cp.end+1)) { // If adding at both ends creates a palindrome other cases are not required
                validPalindromes.push(new Palindrome(cp.start-1, cp.end+1, false));
            } else if(cp.sameChars) { // if all characters are same then adding at each end might create a new palindrome
                if(cp.start>0 && s.charAt(cp.start)==s.charAt(cp.start-1))
                    validPalindromes.push(new Palindrome(cp.start - 1, cp.end));
                if(cp.end<s.length()-1 && s.charAt(cp.end) == s.charAt(cp.end+1))
                    validPalindromes.push(new Palindrome(cp.start, cp.end+1));
            }

        }

        return s.substring(max.start, max.end+1);
    }

    class Palindrome {
        boolean sameChars = true;
        int start=-1, end=-1;
        Palindrome(int s, int e) {
            start = s;
            end = e;
        }

        Palindrome(int s, int e, boolean diff) {
            start = s;
            end = e;
            sameChars = diff;
        }
    }
}
