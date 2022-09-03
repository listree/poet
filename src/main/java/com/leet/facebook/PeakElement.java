package com.leet.facebook;

import com.leet.LeetUtils;

/**
 * https://leetcode.com/problems/find-peak-element/
 * 162. Find Peak Element (Medium)
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater
 * than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 * Runtime 0 ms Beats 100%
 * Memory 41.9 MB Beats 54.56%
 */
public class PeakElement {
    static PeakElement tester = new PeakElement();
    public final static void main(String[] args) {

        int[] nums = {1,2,3,1};
        LeetUtils.printResult(tester.findPeakElement(nums)); // 2

        int[] nums2 = {1,2,1,3,5,6,4};
        LeetUtils.printResult(tester.findPeakElement(nums2)); // 2 or 5

        int[] nums3 = {-2147483648};
        LeetUtils.printResult(tester.findPeakElement(nums3)); // 2 or 5

    }

    public int findPeakElement(int[] nums) {
        int[] arr = new int[nums.length+2];
        for(int i = 0; i < nums.length; i++)
            arr[i+1] = nums[i];

        arr[0] = Integer.MIN_VALUE;
        arr[nums.length+1] = Integer.MIN_VALUE;
        int peakIndex = findPeakElement(arr, 1, nums.length);
        return peakIndex - 1;
    }

    public int findPeakElement(int[] nums, int left, int right) {

        if( left == right )
             return left;

        if( isPeak(nums, left))
            return left;

        if( isPeak(nums, right))
            return right;

        int mid = (left + right) / 2;
        //LeetUtils.printArbitrary(left, mid, right);

        if( isPeak(nums, mid) )
            return mid;

        if( nums[mid] < nums[mid+1] )
            return findPeakElement(nums, mid+1, right-1);
        else
            return findPeakElement(nums, left+1, mid-1);

    }

    boolean isPeak(int[] nums, int i) {

        return nums[i] > nums[i-1] &&  nums[i] > nums[i+1];

    }

}
