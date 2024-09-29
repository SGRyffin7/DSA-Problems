package com.greygryffin.practice.medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] inA = {{'A','A','A','A'}
                        ,{'A','A','A','A'}
                        ,{'A','A','A','A'}};
        String word = "AAAAAAAAB";
//        char[][] inA = {{'A','B'}};
//        String word = "BA";
        System.out.println(new WordSearch().exist(inA, word));
    }

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        if(board.length == 1 && board[0].length==1 && word.length()==1) return board[0][0] == word.charAt(0);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(isWord(board, word, new HashSet<>(), 0, i, j )) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isWord(char[][] board, String word, Set<String> covered, int nextIndex, int i, int j) {
        if(word.charAt(nextIndex) == board[i][j]) {
            if(nextIndex == word.length()-1) return true;
            covered.add(String.valueOf(i)+j);
            if (i-1 >= 0 && !covered.contains(String.valueOf(i-1)+j) && isWord(board, word, covered, nextIndex+1, i-1, j)
                    || (i+1 < board.length && !covered.contains(String.valueOf(i+1)+j) && isWord(board, word, covered, nextIndex+1, i+1, j))
                    || (j+1 < board[0].length && !covered.contains(String.valueOf(i)+(j+1)) && isWord(board, word, covered, nextIndex+1, i, j+1))
                    || (j-1 >=0 && !covered.contains(String.valueOf(i)+(j-1)) && isWord(board, word, covered, nextIndex+1, i, j-1)))
                    return true;
            else {
                covered.remove(String.valueOf(i)+j);
                return false;
            }
        } else {
            return false;
        }
    }
}
