package com.leet.diehard;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Trapping Rain Water (Hard)
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * Runtime: 2 ms, faster than 59.68% of Java online submissions for Trapping Rain Water.
 * Memory: 49 MB, less than 40.75% of Java online submissions for Trapping Rain Water.
 */

public class TrappingRainWater {

    public int trap(int[] height) {

        int L = height.length;
        if( L == 0 )
            return 0;

        int[] leftMax = new int[L];
        int[] rightMax = new int[L];

        leftMax[0] = height[0];
        for(int i = 1; i < L; i++)
            leftMax[i] = Math.max(leftMax[i-1], height[i]);

        rightMax[L-1] = height[L-1];
        for(int i = L-2; i > -1; i--)
            rightMax[i] = Math.max(rightMax[i+1], height[i]);

        int amount =  0;
        for(int i = 0; i < L; i++) {
            amount += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return amount;
    }
}
