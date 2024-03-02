package com.meta;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * 80. Remove Duplicates from Sorted Array II Medium Accepted
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such
 * that each unique element appears at most twice. The relative order of the elements should be kept the same.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int end = 0;

        for(int i = 1; i < nums.length; i++) {
            if( nums[i] == nums[end] && (end > 0) && nums[i] == nums[end-1]) {
                // only twice, so skip this one.
                continue;
            } else {
                end++;
                nums[end] = nums[i];
            }

        }

        return end+1;
    }

}
