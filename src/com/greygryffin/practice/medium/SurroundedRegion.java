package com.greygryffin.practice.medium;
/*
https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegion {
    public static void main(String[] args) {

        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        new SurroundedRegion().solve(board);
    }
    //INCOMPLETE
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board[0].length-1; j++) {
                if(board[i][j] != 'X' && coverUpPossible(board, i, j, visited))
                    coverUp(board, i, j);
            }
        }
        System.out.println();
    }

    public void coverUp(char[][] board, int i, int j) {
        if(i < 0 || i>board.length-1 || j<0 || j > board[0].length-1) return;
        if(board[i][j] != 'X') {
            board[i][j] = 'X';
            coverUp(board, i - 1, j);
            coverUp(board, i + 1, j);
            coverUp(board, i, j - 1);
            coverUp(board, i, j + 1);
        }
    }

    private boolean coverUpPossible(char[][] board, int i, int j, boolean[][] visited) {
        if(i < 0 || i>board.length-1 || j<0 || j > board[0].length-1) return false;
        if(board[i][j] == 'X') return true;
        if(visited[i][j]) return true;
        visited[i][j] = true;

        boolean possible = coverUpPossible(board, i+1, j, visited)
                && coverUpPossible(board, i-1, j, visited)
                && coverUpPossible(board, i, j+1, visited)
                && coverUpPossible(board, i, j-1, visited);
        visited[i][j] = false;
        return possible;
    }

}
