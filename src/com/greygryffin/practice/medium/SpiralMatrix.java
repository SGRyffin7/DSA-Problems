package com.greygryffin.practice.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] ar = {{1,2,3},{4,5,6},{7,8,9}};
        new SpiralMatrix().spiralOrder(ar);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int jLoop = 0, iLoop = 0;
        int i=0, j=0;
        int n=matrix.length, m = matrix[0].length;
        Direction dir = Direction.RIGHT;
        int count = 0;
        while (count < n*m) {
            res.add(matrix[i][j]);
            count++;
            switch (dir) {
                case RIGHT -> {
                    if (j < m-1-jLoop)
                        j++;
                    else {
                        dir = Direction.DOWN;
                        i++;
                    }
                }
                case DOWN -> {
                    if (i < n-1-iLoop)
                        i++;
                    else {
                        dir = Direction.LEFT;
                        j--;
                    }
                }
                case LEFT -> {
                    if (j > iLoop)
                        j--;
                    else {
                        dir = Direction.UP;
                        i--;
                        iLoop++;
                        jLoop++;
                    }
                }
                case UP -> {
                    if (i > jLoop)
                        i--;
                    else {
                        dir = Direction.RIGHT;
                        j++;
                    }
                }
            }
        }
        return res;
    }

    enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }
}
