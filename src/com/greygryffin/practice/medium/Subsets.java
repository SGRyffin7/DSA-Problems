package com.greygryffin.practice.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static void main(String[] args) {
        int[] ar = {1,2,3};
        new Subsets().subsets(ar);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), 0, nums);
        return result;
    }

    void backTrack(List<List<Integer>> res, List<Integer> tmp, int start, int[] nums) {
        res.add(new ArrayList<>(tmp));
        for(int i=start; i<nums.length; i++){
            tmp.add(nums[i]);
            backTrack(res, tmp, i+1, nums);
            tmp.remove(tmp.size()-1);
        }
    }
}
