package com.greygryffin.practice.medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/valid-sudoku/
 */
public class ValidateSudoku {

    public static void main(String[] args) {
        char[][] in = {{'5','3','.','.','7','.','.','.','.'}
                    ,{'6','.','.','1','9','5','.','.','.'}
                    ,{'.','9','8','.','.','.','.','6','.'}
                    ,{'8','.','.','.','6','.','.','.','3'}
                    ,{'4','.','.','8','.','3','.','.','1'}
                    ,{'7','.','.','.','2','.','.','.','6'}
                    ,{'.','6','.','.','.','.','2','8','.'}
                    ,{'.','.','.','4','1','9','.','.','5'}
                    ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new ValidateSudoku().isValidSudoku(in));
    }

    public boolean isValidSudoku(char[][] board) {
        return testRowColumn(board) && testGrid(board);
    }

    boolean testRowColumn(char[][] board){
        for(int i=0; i<9; i++) {
            Set<Character> occurRow = new HashSet<>();
            Set<Character> occurColumn = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[i][j]!='.') {
                    if (occurRow.contains(board[i][j])) return false;
                    occurRow.add(board[i][j]);
                }
                if(board[j][i]!='.') {
                    if (occurColumn.contains(board[j][i])) return false;
                    occurColumn.add(board[j][i]);
                }
            }
        }
        return true;
    }

    private boolean testGrid(char[][] board) {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                Set<Character> occur = new HashSet<>();
                for (int k=i*3; k<i*3+3; k++){
                    for (int l=j*3; l<j*3+3; l++){
                        if(board[k][l] == '.') continue;
                        if(occur.contains(board[k][l])) return false;
                        occur.add(board[k][l]);
                    }
                }
            }
        }
        return true;
    }
}
