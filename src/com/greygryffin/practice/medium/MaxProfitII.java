package com.greygryffin.practice.medium;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i]<prices[i+1])
                totalProfit += prices[i+1] - prices[i];
        }
        return totalProfit;
    }
}
