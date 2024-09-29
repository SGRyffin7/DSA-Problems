package com.greygryffin.practice.hard;

import java.util.ArrayList;

/*
https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("mississippi", "mis*is*ip*."));
    }
    public boolean isMatch(String s, String p) {
        ArrayList<Check> checks = new ArrayList<>();
        for (int i =0; i<p.length(); i++) {
            char c = p.charAt(i);

            if(c == '*') {
                return false;
            }

            if(i<p.length()-1 && p.charAt(i+1) == '*') {
                checks.add(new Check(c, true));
                i++;
            } else {
                checks.add(new Check(c, false));
            }
        }

        int i = 0;
        boolean voidEnabled = false;
        for (int j = 0; j<checks.size(); j++) {
            Check check = checks.get(j);
            if(i>=s.length())
                break;
            if(check.wild && check.repeat) {
                voidEnabled = true;
                continue;
            }

            boolean repeating = check.repeat;
            do {
                if (check.wild || s.charAt(i) == check.c) {
                    i++;
                    if(repeating && i<s.length())
                        repeating = s.charAt(i) == s.charAt(i-1);
                } else if(check.repeat) {
                    break;
                } else {
                    return false;
                }
            } while(repeating && i<s.length());
        }

        return i>=s.length();
    }

    class Check {
        public char c;
        public boolean repeat;
        public boolean wild = false;
        public Check(char c, boolean repeat) {
            if(c == '.')
                wild = true;
            this.c = c;
            this.repeat = repeat;
        }
    }
}
