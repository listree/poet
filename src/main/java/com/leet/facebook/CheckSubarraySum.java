package com.leet.facebook;

import java.util.*;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 523. Continuous Subarray Sum (Medium)
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * A good subarray is a subarray where:
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * Runtime 492 ms Beats 5.2%
 * Memory 58.9 MB Beats 64.13%
 */
public class CheckSubarraySum {

    // Input: nums = [23,2,4,6,7], k = 6
    public final static void main(String[] args) {
        CheckSubarraySum sum = new CheckSubarraySum();
        int[] nums = {23,2,4,6,7};
        System.out.println(sum.checkSubarraySum(nums, 6)); // true
        int[] nums2 = {23,2,6,4,7};
        System.out.println(sum.checkSubarraySum(nums2, 13)); // false
        int[] nums3 = {23,2,4,6,6};
        System.out.println(sum.checkSubarraySum(nums3, 7)); // false

    }

    public boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        for(int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            int residue = sum % k;
            // System.out.println(sum + " " + residue);
            if( map.containsKey(residue) && (i - map.get(residue)) >=2   ) {
                return true;
            }
            if( !map.containsKey(residue) )
                map.put(residue, i);
        }

        return false;
    }

}
