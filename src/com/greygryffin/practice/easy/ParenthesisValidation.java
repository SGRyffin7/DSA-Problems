package com.greygryffin.practice.easy;

/*
https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/
 */
public class ParenthesisValidation {
    public boolean isValid(String s) {
        if(s == null) return true;
        Stack<Character> pStack = new Stack<>();
        for (int i = 0; i< s.length(); i++) {
            char currentChar = s.charAt(i);
            if(isOpenParenthesis(currentChar)) {
                pStack.push(currentChar);
            } else if(pStack.isEmpty() && isClosingParenthesis(currentChar)) {
                return false;
            } else if(isClosingParenthesis(currentChar) && isPairingParenthesis(pStack.peek(), currentChar)) {
                pStack.pop();
            } else {
                return false;
            }
        }
        return pStack.isEmpty();
    }

    public boolean isOpenParenthesis(char ch) {
        return switch (ch) {
            case '{', '[', '(' -> true;
            default -> false;
        };
    }

    public boolean isClosingParenthesis(char ch) {
        return switch (ch) {
            case '}', ']', ')' -> true;
            default -> false;
        };
    }

    public boolean isPairingParenthesis(char open, char closing) {
        return switch (open) {
            case '{' -> closing == '}';
            case '[' -> closing == ']';
            case '(' -> closing == ')';
            default -> false;
        };
    }
}
