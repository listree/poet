package com.leet.google;

/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * 562. Longest Line of Consecutive One in Matrix (Medium)
 * Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.
 * The line could be horizontal, vertical, diagonal, or anti-diagonal.
 */
public class Longest1Matrix {

    public int longestLine(int[][] board) {
        int max = 0;
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
                if(board[i][j] == '1') {
                    if( i == 0 || board[i-1][j] != 1 ) {
                        max = Math.max(max, checkV(i, j, board));
                    }
                    if( j == 0 || board[i][j-1] != 1 ) {
                        max = Math.max(max, checkH(i, j, board));
                    }
                    if( i!= 0 && j!=00 && board[i][j-1] !=1 ) {
                        max = Math.max(max, checkD(i,j, board));
                    }
                }
            }
        }
        return max ;

    }

    int checkV(int i, int j, int[][] board) {
        int v = 1;
        for( int x = i + 1; x < board[0].length; x++) {
            if( board[x][j] == '1' ) {
                v++;
            } else{
                return v ;
            }
        }
        return v;
    }

    int checkH(int i, int j, int[][] board) {
        int v = 1;
        for( int x = j + 1; x < board.length; x++) {
            if( board[i][x] == '1' ) {
                v++;
            } else{
                return v ;
            }
        }
        return v;
    }

    int checkD(int i, int j, int[][] board) {
        int v = 1;
        for( int x = j + 1, y = i+1 ; x < board.length && y < board[0].length; x++, y++) {
            if( board[i][x] == '1' ) {
                v++;
            } else{
                return v ;
            }
        }
        return v;
    }


}
