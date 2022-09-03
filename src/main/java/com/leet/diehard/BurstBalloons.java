package com.leet.diehard;

/**
 * https://leetcode.com/problems/burst-balloons/
 * 312. Burst Balloons (Hard)
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array
 * nums. You are asked to burst all the balloons. If you burst the ith balloon, you will get
 * nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array,
 * then treat it as if there is a balloon with a 1 painted on it.
 * Return the maximum coins you can collect by bursting the balloons wisely.
 * Runtime: 230 ms, faster than 19.96% of Java online submissions for Burst Balloons.
 * Memory: 43.5 MB, less than 27.72% of Java online submissions for Burst Balloons.
 */
public class BurstBalloons {
    public static void main(String[] args) {
        BurstBalloons ha = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        // nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
        // coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
        System.out.println(ha.maxCoins(nums) == 167);

        int[] nums2 = {1, 5}; //Output: 10
        // nums = [1,5] --> [5]
        // coins =  1*1*5 + 1*5*1
        System.out.println(ha.maxCoins(nums2) == 10);
    }

    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] arr = new int[N + 2];
        arr[0] = 1;
        arr[N+1] = 1;
        for (int i = 0; i < N; i++)
            arr[i+1] = nums[i];

        // Note: mem[i][j] is max value of burst balloons between i and j
        // Example: mem[0][N+1] is burst arr[1] to arr[N] i.e. nums[0] to nums[N-1]
        int[][] mem = new int[N+2][N+2];
        return burst(mem, arr, 0, N+1);
    }

    public int burst(int[][] mem, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (mem[left][right] > 0) return mem[left][right];
        int maxValue = 0;
        for (int i = left + 1; i < right; i++)
            maxValue = Math.max(maxValue, nums[left] * nums[i] * nums[right]
                    + burst(mem, nums, left, i) + burst(mem, nums, i, right));
        mem[left][right] = maxValue;
        return maxValue;
    }

}
