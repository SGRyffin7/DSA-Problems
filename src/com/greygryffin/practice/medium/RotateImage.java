package com.greygryffin.practice.medium;


/*
https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] in = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        new RotateImage().tryTwo(in);
        System.out.println(in.toString());
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==1) return;

        for(int j=0; j<n/2; j++) {
            for (int i = j; i < n-1-j; i++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[n-1 - i][j];
                matrix[n-1 - i][ j] = matrix[n-1 - j][n-1 - i];
                matrix[n-1 - j][n-1 - i] = matrix[i][n-1 - j];
                matrix[i][n-1 - j] = tmp;
            }
        }
    }

    private void tryTwo(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix.length ==1) return;
        int n = matrix.length;
        for(int l = 0; l<n/2; l++){
            for(int off=l; off<n-1-l; off++){
                int temp = matrix[l][off];
                matrix[l][off] = matrix[n-1-off][l];
                matrix[n-1 - off][l] = matrix[n-1 - l][n-1 - off];
                matrix[n-1 - l][n-1 - off] = matrix[off][n-1 - l];
                matrix[off][n-1 - l] = temp;
            }
        }
    }
}
