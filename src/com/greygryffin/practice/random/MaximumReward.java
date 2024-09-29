package com.greygryffin.practice.random;

import java.util.HashMap;

public class MaximumReward {
    public static void main(String[] args) {
        int[] ni = {4, 8, 1, 10, 2};
        System.out.println(new MaximumReward().maxRew(ni, 0, 2, new HashMap<>()));
    }
    int maxRew(int[] ar, int startAt, int capacity, HashMap<String, Integer> mem) {
        String key = String.valueOf(startAt) + capacity;
        if(startAt == ar.length-1 && capacity>0){
            mem.put(key, ar[startAt]);
            return ar[startAt];
        }

        if(capacity == 0)
            if(startAt!=ar.length-1)
                return maxRew(ar, startAt+1, 1, mem);
            else
                return 0;

        if(startAt+capacity >= ar.length-1){
            mem.put(key, maxRew(ar, startAt+1, capacity-1, mem)+ar[startAt]);
            return mem.get(key);
        }
        int max = Math.max(ar[startAt] + maxRew(ar, startAt+1, capacity-1, mem), maxRew(ar, startAt+1, capacity+1, mem));
        mem.put(key, max);
        return max;
    }
}
