package com.leet.diehard;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * 41. First Missing Positive (Hard)
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * Runtime: 2 ms, faster than 91.39% of Java online submissions for First Missing Positive.
 * Memory: 57.4 MB, less than 82.83% of Java online submissions for First Missing Positive.
 */
public class FirstMissingPositive {

    public final static void main(String[] arg) {
        FirstMissingPositive ha = new FirstMissingPositive();
        int[] nums = {0,1,2};
        System.out.println( "=" + ha.firstMissingPositive(nums)); // 3

        int[] nums2 = {3,4,-1,1};
        System.out.println( "" + ha.firstMissingPositive(nums2)); // 2

        int[] nums3 = {7,8,9,11,12};
        System.out.println( "=" + ha.firstMissingPositive(nums3)); // 1
    }

    public int firstMissingPositive(int[] nums) {

        int N = nums.length;
        for(int i = 0; i < N; i++) {
            int x = nums[i];
            while (x > 0 && x <= N && x != nums[x - 1]) {
                // swap i, nums[i] -1 to make nums[i] at right place
                int temp = nums[x-1];
                nums[x-1] = x; // !!!right place !!!
                nums[i] = temp;
                x = nums[i];
            }
        }

        for(int x : nums) System.out.print(x + ":");

        for(int i = 0; i < nums.length; i++) {
            if( nums[i] != (i+1) )
                return i+1;
        }
        return N+1;
    }

}
