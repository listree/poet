package com.leet.diehard;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 154. Find Minimum in Rotated Sorted Array II (Hard)
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array
 * nums = [0,1,4,4,5,6,7] might become:
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * You must decrease the overall operation steps as much as possible.
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array II.
 * Memory: 42.1 MB, less than 92.56% of Java online submissions for Find Minimum in Rotated Sorted Array II.
 */
public class FindMinRotatedSortedII {
    public static void main(String[] args) {
        FindMinRotatedSortedII ha = new FindMinRotatedSortedII();
        int[] nums = {4,5,6,7,0,1,4};
        System.out.println("min=" + ha.findMin(nums));
        int[] nums2 = {3,3,1,3};
        System.out.println("min=" + ha.findMin(nums2));
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if ( nums[left] < nums[right] ) // whole ascending case, min at begin
                return nums[left];

            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) // right ascending, min in left part
                right = middle;
            else if (nums[middle] > nums[right]) // right out of order, min in right part
                left = middle + 1;
            else // middle equals right, don't know where min is
                right--;
        }

        return nums[left];
    }

}
