package com.greygryffin.practice.medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] ar = {};
        System.out.println(new JumpGame().canJump(ar));
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, 0, new HashSet<>());
    }

    public boolean canJump(int[] nums, int i, Set<Integer> reachable) {
        if(i==nums.length-1) return true;
        int maxReach= Math.min(i + nums[i], nums.length - 1);
        for(int j=maxReach; j>i; j--){
            if(canJump(nums, j, reachable)) {
                reachable.add(i);
                return true;
            }
        }
        return false;
    }

    public boolean canJumpOld(int[] nums) {
        if(nums.length == 1) return nums[0]>0;
        Set<Integer> reachable = new HashSet<>();
        for(int i=nums.length-1; i>-1; i--) {
            if(nums[i]+i >= nums.length-1) {
                reachable.add(i);
            } else {
                for(int j=i+nums[i]; j>i; j--){
                    if(reachable.contains(j)) {
                        reachable.add(i);
                        break;
                    }
                }
            }
        }
        return reachable.contains(0);
    }
}
