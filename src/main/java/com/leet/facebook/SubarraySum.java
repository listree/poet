package com.leet.facebook;

import java.util.*;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 560. Subarray Sum Equals K (Medium)
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * Runtime 26 ms Beats 56.53%
 * Memory 47.3 MB Beats 13.25%
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        if( nums == null || nums.length == 0)
            return 0;

        int total = 0, sum = 0 ;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if( map.containsKey(target))
                total += map.get(target);
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return total;
    }

}
