package com.greygryffin.practice.medium;

/*
https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    public static void main(String[] args) {
        new CountAndSay().countAndSay(4);
    }
    public String countAndSay(int n) {
        String init = "1";
        for(int i=2; i<=n; i++){
            init = countAndSay(init);
        }
        return init;
    }

    public String countAndSay(String in) {
        StringBuilder result = new StringBuilder();
        int c =1;
        char lastChar = in.charAt(0);
        for(int i=1; i<in.length(); i++) {
            if(in.charAt(i)==lastChar)
                c++;
            else {
                result.append(c);
                result.append(lastChar);
                c = 1;
                lastChar = in.charAt(i);
            }
        }
        result.append(c);
        result.append(lastChar);
        return result.toString();
    }

    private String tryTwo(int in) {
        String out = "1";
        for (int i=1; i<in; i++){
            out = tryTwo(out);
        }
        return out;
    }

    private String tryTwo(String in) {
        StringBuilder sb = new StringBuilder();
        char curChar = in.charAt(0);
        int curCount = 1;
        for(int i=1; i<in.length(); i++) {
            if(in.charAt(i) == curChar){
                curCount++;
            } else {
                sb.append(curCount).append(curChar);
                curChar = in.charAt(i);
                curCount = 1;
            }
        }
        return sb.toString();
    }
}
