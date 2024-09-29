package com.greygryffin.practice.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("()");
        for(int i=1; i<n; i++) {
            boolean first = true;
            while (q.peek().length() == i*2) {
                String tmp = q.poll();
                if(first) {
                    q.offer(tmp + "()");
                    q.offer("("+tmp+")");
                    first = false;
                } else {
                    q.offer("()"+tmp);
                    q.offer(tmp+"()");
                    q.offer("("+tmp+")");
                }
            }
        }
        return q.stream().toList();
    }
}
