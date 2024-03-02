package com.bloom;

/**
 * 26. Remove Duplicates from Sorted Array Solved Easy
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        int j = 0;

        while( j < nums.length ) {

            if( (j + 1) < nums.length && nums[j] == nums[j+1]) {
                j++;
            } else {
                nums[k] = nums[j];
                k++;
                j++;
            }
        }

        return k;
    }

}
