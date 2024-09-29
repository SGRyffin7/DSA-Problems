package com.greygryffin.practice.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes test = new SetMatrixZeroes();
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        test.tryTwo(arr);
        System.out.println(arr);
    }
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> x = new HashSet<>();
        HashSet<Integer> y = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        Iterator<Integer> xIter = x.iterator();
        Iterator<Integer> yIter = y.iterator();

        while (xIter.hasNext()) {
            int i = xIter.next();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        while (yIter.hasNext()) {
            int j = yIter.next();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * Marking the zero row and column using a constant
     * @param matrix
     */
    private void tryTwo(int[][] matrix) {

        boolean iZero = false;
        for(int i=0; i<matrix.length; i++){
            if (matrix[i][0] == 0) {
                iZero = true;
                break;
            }
        }

        boolean jZero = false;
        for(int j=0; j<matrix[0].length; j++){
            if (matrix[0][j] == 0) {
                jZero = true;
                break;
            }
        }

        if(matrix.length > 1 && matrix[0].length > 1) {
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0] == 0) {
                for(int j=1; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for (int i=1; i<matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }

        }

        if (iZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (jZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

    }
}
