package com.walm;

import java.util.*;

/**
 * 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    public final static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        List<Integer> arr = spiralMatrix.spiralOrder(matrix);
        for(int x: arr) System.out.print(" " + x);

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        List<Integer> arr = new ArrayList<Integer>();
        while (left <= right && top <= bottom) {

            // scan top then remove top
            for (int col = left; col <= right; col++)
                arr.add(matrix[top][col]);
            top++;
            if( top > bottom) break;

            // scan right then remove right
            for (int row = top; row <= bottom; row++)
                arr.add(matrix[row][right]);
            right--;
            if( right < left) break;

            // scan bottom then remove bottom
            for (int col = right; col >= left; col--)
                arr.add(matrix[bottom][col]);

            bottom--;
            if( bottom < top) break;

            // scan left then remove left
            for (int row = bottom; row >= top; row--)
                arr.add(matrix[row][left]);

            left++;
            if( left > right) break;

        }

        return arr;
    }

}
