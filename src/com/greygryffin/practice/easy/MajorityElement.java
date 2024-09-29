package com.greygryffin.practice.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityWithMapElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if(countMap.containsKey(num)) {
                int count = countMap.get(num);
                if(count == nums.length/2) return num;
                countMap.put(num,  + 1);
            } else
                countMap.put(num, 1);
        }
        return nums[nums.length-1];
    }

    public int majorityBySortElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int cleverMajorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else count--;

        }
        return major;
    }
}
