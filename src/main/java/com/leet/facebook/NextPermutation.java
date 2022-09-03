package com.leet.facebook;

/**
 * https://leetcode.com/problems/next-permutation/
 * 31. Next Permutation (Medium)
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * For example, for arr = [1,2,3], the following are all the permutations of arr:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
 * then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * The replacement must be in place and use only constant extra memory.
 * Runtime 1 ms Beats 66.90%
 * Memory 42.6 MB Beats 75.58%
 */
public class NextPermutation {
    public final static void main(String[] args) {
        NextPermutation leet = new NextPermutation();

        int[] nums = {1,2,3};
        leet.nextPermutation(nums);
        leet.printArr(nums); // Output: [1,3,2]

        int[] nums2 = {3,2,1};
        leet.nextPermutation(nums2);
        leet.printArr(nums2); // Output: [1,2,3]

        int[] nums3 = {1,1,5};
        leet.nextPermutation(nums3);
        leet.printArr(nums3); // Output: [1,5,1]

        int[] nums4 = {1,3,2};
        leet.nextPermutation(nums4);
        leet.printArr(nums4); // Output: [2,1,3]

        int[] nums5 = {1,5,1};
        leet.nextPermutation(nums4);
        leet.printArr(nums4); // Output: [5,1,1]

    }

    public void nextPermutation(int[] nums) {

        // Find the first index from end, say x, where nums[x] < nums[x + 1].
        int x = nums.length - 2;
        for(; x > -1; x--) {
            if( nums[x] < nums[x+1] ) {
                break;
            }
        }

        // Find the first index from x, say y, where nums[x] > nums[y]
        if( x == -1 ) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        int y = x + 1;
        for(; y < nums.length; y++) {
            if( nums[y] <= nums[x] ) {
                y--;
                break;
            }
        }

        if( y == nums.length )
            y--;

        // Swap nums[x] and nums[y].
        swap(nums, x, y);

        // Reverse all elements from x + 1 till the end i.e. n -1
        reverse(nums, x+1, nums.length-1);
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        int len = (end - start + 1) / 2;
        for( int i = 0; i < len; i++)
            swap(nums, start+i, end-i);
    }

    private void printArr(int[] nums) {
        System.out.print("arr");
        for(int x: nums)
            System.out.print("-"+ x);
        System.out.println("");
    }

}
