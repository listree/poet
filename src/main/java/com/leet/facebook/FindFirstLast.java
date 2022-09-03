package com.leet.facebook;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. Find First and Last Position of Element in Sorted Array (Medium)
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * Runtime 0 ms Beats 100%
 * Memory 45.5 MB Beats 85.41%
 */
public class FindFirstLast {

    public final static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10}; //   4 8 8 8 9
        FindFirstLast findFirstNLast = new FindFirstLast();
        int[] output = findFirstNLast.searchRange(nums, 8);
        System.out.println(output[0] + " " + output[1]); // Output: [3,4]

        int[] nums2 = {5,7,7,8,8,10};
        int[] output2 = findFirstNLast.searchRange(nums2, 6);
        System.out.println(output2[0] + " " + output2[1]); // Output: [-1,-1]

        int[] nums3 = {};
        int[] output3 = findFirstNLast.searchRange(nums3, 0);
        System.out.println(output3[0] + " " + output3[1]); // Output: [-1,-1]

    }

    public int[] searchRange(int[] nums, int target) {
        if( nums == null || nums.length == 0) {
            int[] result = {-1, -1};
            return result;
        } else {
            int start = findStart(nums, 0, nums.length - 1, target);
            int end = findEnd(nums, 0, nums.length - 1, target);
            int[] result = {start, end};
            return result;
        }
    }

    private int findEnd(int[] nums, int start, int end, int target) {

        if( nums[end] == target ) {
            return end;
        } else if( nums[end] < target ) {
            return -1;
        } else { // nums[end]  > target,
            if (nums[start] > target)
                return -1;

            // target must be inside [start, end]
            int mid = (start + end) / 2;
            //System.out.println(start + " " + end + " " + mid);

            if (nums[mid] > target) {
                return findEnd(nums, start, mid-1, target);
            } else if (nums[mid] < target) {
                return findEnd(nums, mid + 1, end, target);
            } else {
                return findEnd(nums, mid, end-1, target);
            }
        }

    }

    private int findStart(int[] nums, int start, int end, int target) {

        if( nums[start] == target ) {
            return start;
        } else if( nums[start] > target ) {
            return -1;
        } else if (nums[end] < target) {
            return -1;
        } else { // nums[start] < target, nums[end] >= target, inside [start, end]
            int mid = (start + end) / 2;
            //System.out.println(start + " " + end + " " + mid);
            if (nums[mid] > target) {
                return findStart(nums, start, mid-1, target);
            } else if (nums[mid] < target) {
                return findStart(nums, mid + 1, end, target);
            } else {
                return findStart(nums, start+1, mid, target);
            }
        }

    }

}
