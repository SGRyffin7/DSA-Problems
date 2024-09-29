package com.greygryffin.practice.medium;

import java.util.Deque;
import java.util.LinkedList;

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] in = {"2","1","+","3","*"};
        new ReversePolishNotation().evalRPN(in);
    }
    public int evalRPN(String[] tokens) {
        Deque<String> tokenStack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if(isOperand(tokens[i])) {
                tokenStack.push(operate(tokenStack.pop(), tokenStack.pop(), tokens[i]));
            } else {
                tokenStack.push(tokens[i]);
            }
        }
        return Integer.parseInt(tokenStack.pop());
    }

    private String operate(String op2, String op1, String token) {
        int result = 0, ope1 = Integer.parseInt(op1), ope2 = Integer.parseInt(op2);
        switch (token) {
            case "+" : {
                result = ope1+ope2;
                break;
            }
            case "-" : {
                result = ope1-ope2;
                break;
            }
            case "*" : {
                result = ope1*ope2;
                break;
            }
            case "/" : {
                result = ope1/ope2;
            }
        }
        return String.valueOf(result);
    }

    private boolean isOperand(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
