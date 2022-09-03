package com.leet.facebook;

/**
 * https://leetcode.com/problems/move-zeroes/
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Runtime 2 ms Beats 46.89%
 * Memory 44.2 MB Beats 22.14%
 */
public class MoveZeroes {

    // [0,1,0,3,12]
    // [0,0,0,3,12]
    // [1,1,0,3,12]
    // [1,0,0,3,12]

    public void moveZeroes(int[] nums) {

        if( nums == null || nums.length <= 1 )
            return;

        int start = 0;
        int end = (nums[0] == 0 ) ? 1: 0;

        for( int i = 1; i < nums.length; i++) {
            if( nums[i] == 0 ) {
                if( start == end ) {
                    start++; end++; end++;
                } else {
                    end++;
                }
            } else { // nums[i] != 0
                if( start == end ) {
                    start++;
                    end++;
                } else {
                    nums[start] = nums[i];
                    nums[i] = 0;
                    start++;
                    end++;
                }
            }
        }

    }

}
