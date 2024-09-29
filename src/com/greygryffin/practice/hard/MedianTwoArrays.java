package com.greygryffin.practice.hard;

/**
 * https://leetcode.com/problem-list/top-interview-questions/
 */
public class MedianTwoArrays {

    public static void main(String[] args) {
        int[] ar1 = {1, 2, 5}, ar2 = {3, 4, 6};
        double median = new MedianTwoArrays().medianOfTwo(ar1, ar2);
        System.out.println(median);
    }
    public double medianOfTwo(int[] nums1, int[] nums2) {
        int len1 = nums1.length,
                len2 = nums2.length,
                lenSum = len1+len2,
                p1 = 0,
                p2 = 0,
                median1 = -1,
                median2 = -1;

        boolean singleMedian = lenSum%2 == 1;

        if(singleMedian) {
            median1 = lenSum/2;
        } else {
            median2 = lenSum/2;
            median1 = median2-1;
        }

        double median = 0f;

        for (int i=0; i<lenSum; i++) {
            if((p2 >= len2 && p1<len1) || (p1<len1 && nums1[p1] < nums2[p2])) {
                if(median1 == i) {
                    median = nums1[p1];
                    if(singleMedian)
                        break;
                }
                if (median2 == i) {
                    median += nums1[p1];
                    median /= 2;
                    break;
                }
                p1++;
            } else if(p2<len2) {
                if(median1 == i) {
                    median = nums2[p2];
                    if(singleMedian)
                        break;
                }
                if (median2 == i) {
                    median += nums2[p2];
                    median /= 2;
                    break;
                }
                p2++;
            } else {
                break;
            }
        }
        return median;
    }
}
