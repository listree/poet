package com.meta;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 * 64. Minimum Path Sum Medium
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] min = new Integer[m][n];
        return minPathSum(grid, m - 1, n -1, min);
    }

    private int minPathSum(int[][] grid, int m, int n, Integer[][] min) {

        if( min[m][n] != null )
            return min[m][n];

        if( m == 0 & n == 0) {
            min[m][n] = grid[0][0];
        } else if( m == 0 ) {
            min[m][n] = minPathSum(grid, 0, n - 1, min) + grid[0][n];
        } else if( n == 0 ) {
            min[m][n] =  minPathSum(grid, m - 1, 0, min) + grid[m][0];
        } else {
            min[m][n] = Math.min(
                    minPathSum(grid, m - 1, n, min),
                    minPathSum(grid, m, n - 1, min)
            ) + grid[m][n];
        }
        return min[m][n];

    }

}
