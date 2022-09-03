package com.walm;

/**
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */
public class SortColors {
    public final static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        sortColors.sortColors(nums);
        for( int i : nums) System.out.print(" " + i);

        System.out.println();
        int[] nums2 = {2,0,1};
        sortColors.sortColors(nums2);
        for( int i : nums2) System.out.print(" " + i);

    }

    // The "Sort Colors" problem, also known as the Dutch National Flag problem,
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length -1;

        while( mid <= right  ) {
            if( nums[mid] == 0 ) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if ( nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, right);
                right--;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
