package com.greygryffin.practice.medium;

/**
 * Increasing triplet leetcode
 */
public class IncreasingTriplets {
    public static void main(String[] args) {
        IncreasingTriplets test = new IncreasingTriplets();
        int[] arr = {20, 18, 16, 10, 11, 5, 3, 21};
        System.out.println(test.increasingTriplet(arr));
    }
    private boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int n: nums) {
            if (n < first) {
                first = n;
            } else if (n < second && n != first) {
                second = n;
            }

            if(n > first && n > second) {
                return true;
            }
        }

        return false;
    }
}
