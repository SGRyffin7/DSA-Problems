package com.greygryffin.practice.random;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i =0; i<size; i++) {
            arr[i] = scanner.nextInt();
            if(arr[i]>-1)
                set.add(arr[i]);
        }

        for(int i = 0; i<size; i++) {
            if(arr[i]<0 && set.contains(arr[i]*-1)) {
                arr[i] = arr[i]*-1;
            }
        }

        int maxSum = 0;
        int currSum = 0;
        for(int i = 0; i<size; i++){
            if(arr[i]>-1) {
                currSum += arr[i];
            } else {
                currSum = 0;
            }
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }

        System.out.println(maxSum);
    }
}