package com.leet.general;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 238. Product of Array Except Self (Medium)
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
 * Memory: 50.8 MB, less than 88.41% of Java online submissions for Product of Array Except Self.
 */
public class MediumProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] left = new int[N];
        int[] right = new int[N];

        left[0] = nums[0];
        for(int i = 1; i < N; i++) {
            left[i] = left[i-1] * nums[i];
        }

        right[N-1] = nums[N-1];
        for(int i = N-2; i > -1; i--) {
            right[i] = right[i+1] * nums[i];
        }

        int[] product = new int[N];
        product[0] = right[1];
        product[N-1] = left[N-2];
        for(int i = 1; i <= N-2; i++) {
            product[i] = left[i-1] * right[i+1];
        }

        return product;
    }

}
