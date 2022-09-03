package com.walm;
// @see https://leetcode.com/problems/3sum-closest/description/

import java.util.Arrays;

/** 16. 3Sum Closest
 *  Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * -4, -1, 1, 2 -> 1
 *
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */
public class ThreeSumClosest {

    public final static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {-1,2,1,-4}; // -4, -1. 1, 2
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Set two pointers at the beginning and end of the remaining array
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(currentSum - target) < Math.abs(closestSum - target))
                    closestSum = currentSum;

                if ( currentSum > target)
                    right--;
                else if (currentSum < target)
                    left++;
                else
                    return currentSum;
            }
        }
        return closestSum;
    }

}
