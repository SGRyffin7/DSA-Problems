package com.greygryffin.practice.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        int[] in = {0,1,2,3};
        new Permutations().permuteB(in);
    }
    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(List.of(nums[0]));
        for(int i=1; i<nums.length; i++){
            while(q.peek().size() == i) {
                List<Integer> cur = q.poll();
                for(int j=0; j<cur.size(); j++){
                    List<Integer> newList = new ArrayList<>(cur);
                    newList.add(j, nums[i]);
                    q.offer(newList);
                }
                List<Integer> newList = new ArrayList<>(cur);
                newList.add(nums[i]);
                q.offer(newList);
            }
        }
        return q.stream().toList();
    }

    public List<List<Integer>> permuteB(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
