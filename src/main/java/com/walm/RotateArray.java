package com.walm;

/**
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {

    public final static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        // Input: nums = [1,2,3,4,5,6,7], k = 3
        // Output: [5,6,7,1,2,3,4]
        int[] nums = {1,2,3,4,5,6,7};
        rotateArray.rotate(nums, 3);
        for( int x: nums)
            System.out.print(" " + x);

    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] arr1 = new int[n-k]; // 4
        int[] arr2 = new int[k]; //3

        System.arraycopy(nums, 0, arr1,  0, n - k);
        System.arraycopy(nums, n-k, arr2,  0, k);

        System.arraycopy(arr1, 0, nums,  k, n - k );
        System.arraycopy(arr2, 0, nums,  0, k);

    }

}
