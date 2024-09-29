package com.greygryffin.practice.easy;

import java.util.LinkedList;

/*
https://leetcode.com/problems/climbing-stairs/
 */

public class ClimbStairs {
    public int climbStairsRecursive(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
        }
    }

    public int climbStairsRecurseLoop(int n) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(n);
        int result = 0;
        while (stack.size() > 0) {
            int toCalculate = stack.pop();
            if (toCalculate == 1)
                result += 1;
            else if (toCalculate == 2)
                result += 2;
            else if (toCalculate > 2) {
                stack.push(toCalculate - 1);
                stack.push(toCalculate - 2);
            }
        }
        return result;
    }

    public int climbStairsDP(int n) {
        if (n < 2)
            return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsTwoVariables(int n) {
        if (n < 2)
            return 1;

        int oneStep = 1;
        int twoStep = 1;
        for (int i = 2; i <= n; i++) {
            int t = oneStep;
            oneStep = oneStep + twoStep;
            twoStep = t;
        }
        return oneStep;
    }

}
