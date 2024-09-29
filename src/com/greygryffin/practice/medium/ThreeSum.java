package com.greygryffin.practice.medium;

import java.util.*;

/*
https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] in = {-1,0,1,2,-1,-4};
        ThreeSum test = new ThreeSum();
        System.out.println(test.threeSum(in));
        test.tryTwo(in);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> set = new HashMap<>();
        List<List<Integer>> triplets = new ArrayList<>();

        // calculate diff required for each
        for (int num : nums) set.put(num, set.getOrDefault(num, 0) +1);

        for (int key : set.keySet()) {
            if (key == 0 && set.get(0) >= 3) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(0);
                tmp.add(0);
                tmp.add(0);
                triplets.add(tmp);
            } else if (key != 0 && set.get(key) >= 2 && set.containsKey(-key * 2)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(key);
                tmp.add(key);
                tmp.add(-key * 2);
                triplets.add(tmp);
            }
        }
        Set<Integer> keySetI =  new HashSet<>(set.keySet());
        for(int keyI : set.keySet()) {
            keySetI.remove(keyI);
            Set<Integer> keySetJ =  new HashSet<>(keySetI);
            for(int keyJ : keySetI) {
                keySetJ.remove(keyJ);
                if(keySetJ.contains(-(keyI + keyJ))){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(keyI);
                    tmp.add(keyJ);
                    tmp.add(-(keyI + keyJ));
                    triplets.add(tmp);
                }
            }
        }

        return triplets;
    }

    private List<List<Integer>> tryTwo(int[] nums) {
        Set<Set<Integer>> result = new HashSet<>();
        HashMap<Integer, List<List<Integer>>> twoSum = new HashMap<>();

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        nums = null;

        Integer[] numSetArr = new Integer[numSet.size()];
        numSet.toArray(numSetArr);
        numSet = null;

        for(int i=0; i<numSetArr.length-1; i++){
            for(int j=i+1; j<numSetArr.length; j++) {
                int sum = numSetArr[i] + numSetArr[j];
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(numSetArr[i]);
                arr.add(numSetArr[j]);
                if(!twoSum.containsKey(sum)){
                    twoSum.put(sum, new ArrayList<>());
                }
                twoSum.get(sum).add(arr);
            }
        }

        for (Integer num : numSetArr) {
            if (twoSum.containsKey(-num)) {
                List<List<Integer>> twoSumSet = twoSum.get(-num);
                for (List<Integer> set : twoSumSet) {
                    Set<Integer> arr = new HashSet<>(set);
                    if (arr.contains(num)) continue;
                    arr.add(num);
                    result.add(arr);
                }
            }
        }

        System.out.println(result);

        List<List<Integer>> ret = new ArrayList<>();
        for (Set<Integer> curSet : result) {
            ret.add(curSet.stream().toList());
        }
        return ret;
    }

}
