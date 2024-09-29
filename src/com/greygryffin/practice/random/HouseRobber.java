package com.greygryffin.practice.random;

public class HouseRobber {
    public int robHouses(int[] wealth){
        if(wealth == null || wealth.length==0) return 0;
        if(wealth.length == 1) return wealth[0];
        if(wealth.length == 2) return Math.max(wealth[0], wealth[1]);

        int[] profits =  new int[wealth.length];
        profits[profits.length-1] = wealth[wealth.length-1];
        profits[profits.length-2] = Math.max(wealth[wealth.length-2], wealth[wealth.length-1]);
        for (int i = profits.length-3; i>=0; i--) {
            profits[i] = Math.max(profits[i+1], profits[i+2]+wealth[i]);
        }
        return profits[0];
//        return robTopDown(wealth, 0, profits);
    }

    public int robTopDown(int[] houses, int curHouse, int[] maxProfit){
        if(maxProfit[curHouse] != 0) return maxProfit[curHouse];
        if(curHouse > houses.length) return 0;

        int steal = houses[curHouse] + robTopDown(houses, curHouse+2, maxProfit);
        int skip = robTopDown(houses, curHouse+1, maxProfit);

        maxProfit[curHouse] = Math.max(steal, skip);

        return maxProfit[curHouse];
    }
}
