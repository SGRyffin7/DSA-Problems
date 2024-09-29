package com.greygryffin.practice.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        for(int i=0, j=0; i<nums1.length && j<nums2.length; ) {
            if(nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else {
                if(nums1[i]<nums2[j])
                    i++;
                else
                    j++;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
