package com.leet.diehard;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 329. Longest Increasing Path in a Matrix (Hard)
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down.
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 * Runtime: 49 ms, faster than 12.65% of Java online submissions for Longest Increasing Path in a Matrix.
 * Memory: 43.5 MB, less than 86.62% of Java online submissions for Longest Increasing Path in a Matrix.
 */
public class LongestIncPath {

    public final static void main(String[] args) {
        LongestIncPath test = new LongestIncPath();
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        //System.out.println(test.longestIncreasingPath(matrix));
        int[][] matrix2 = {
                {3,4,5},
                {3,2,6},
                {2,2,1}};
        //System.out.println(test.longestIncreasingPath(matrix2));
        int[][] matrix3 = {
                {17,4,6,  11,4,0,17,12,19,12,12, 0},
                {0,  6,4,   4, 5,9,15,1,   11,13,18, 0},
                {4,  2,13, 1, 2,7,15,5,   14,6,  8,   6}};
        System.out.println(test.longestIncreasingPath(matrix3));

    }


    class Cell implements Comparable<Cell> {
        int x, y, value, path;
        Cell(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.value = v;
            this.path = -1;
        }
        public int compareTo(Cell o) {
            return o.value - this.value;
        }
        public String toString() {
            return x + "," + y + "," + value + "(" + path +")";
        }
    }

    int N, M, F;
    HashMap<Integer, Cell> hash ;
    public int longestIncreasingPath(int[][] matrix) {
        N = matrix.length;
        M = matrix[0].length;
        F = Math.max(N,M);
        int maxPath = 1;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        hash = new HashMap<Integer, Cell>();
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) {
                Cell cell = new Cell(i ,j, matrix[i][j]);
                pq.add(cell);
                hash.put( i * F + j, cell);
            }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while( !pq.isEmpty() ) {
            Cell cell = pq.poll();
            cell.path = 1;
            for(int i = 0; i < 4; i++) {
                Cell neighbor = getValidNeighbor(cell, directions[i]);
                if( neighbor != null ) {
                   cell.path = Math.max(cell.path, neighbor.path + 1);
               }
            }
            maxPath = Math.max(maxPath, cell.path);
        }

        return maxPath;
    }

    Cell getValidNeighbor(Cell cell, int[] direction) {
        int x = cell.x + direction[0];
        int y = cell.y + direction[1];
        if( x < 0 || x >= N || y < 0 || y >= M ) // check boundary
            return null;
       Cell neighbor =  hash.get( x * F + y );
       if( neighbor.value <= cell.value) // skip desc neighbor
           return null;
       return neighbor;
    }

}
