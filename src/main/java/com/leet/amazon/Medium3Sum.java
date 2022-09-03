package com.leet.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * 15. 3Sum (Medium)
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * todo: Wrong answer to fix !!!
 */
public class Medium3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < (nums.length - 1); i++) {
            for( int j = i + 1; j < (nums.length - 1); j++ )
                twoSum(nums, j, -nums[i], list);
        }
        return list;
    }

    public void twoSum(int[] nums, int start, int target, List<List<Integer>> list) {
        // find x + y = target
        for( int i = start; i < (nums.length-1); i++) {
            for( int j = i+1; j < nums.length; j++) {
                if( nums[i] + nums[j] == target ) {
                    list.add(Arrays.asList(-target, nums[i], nums[j]));
                }
            }
        }

    }

}
