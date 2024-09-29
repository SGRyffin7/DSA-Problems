package com.greygryffin.practice.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/gas-station/
23:56
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5,5,70};
        int[] cost = {2,3,4,3,9,6,2};
        new GasStation().canCompleteCircuit(gas, cost);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length==0 || cost == null ||  cost.length == 0 || gas.length != cost.length) return -1;

        if(gas.length == 1) return gas[0] >= cost[0]? 0 : -1;
        int gasSum = 0;
        int costSum = 0;
        for (int i= 0; i<gas.length; i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(costSum>gasSum) return -1;

        int surplus = 0;
        int start = 0;

        for(int i=0; i<gas.length; i++){
            surplus += gas[i]-cost[i];
            if(surplus<0){
                start = i+1;
                surplus = 0;
            }
        }

        return start;
    }

}