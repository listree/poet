package com.bloom;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 128. Longest Consecutive Sequence Solved Medium
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence
 * You must write an algorithm that runs in O(n) time. 128. Longest Consecutive Sequence Medium
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
public class longestConsecutiveArray {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums)
            set.add(x);

        int longest = 0 ;
        for( int x: set ) {
            if( !set.contains(x-1) ) {
                // only one without previous number can be starting of consecutive sequence.
                int count = 1;
                while( set.contains(x+1) ) {
                    count++;
                    x++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

}
