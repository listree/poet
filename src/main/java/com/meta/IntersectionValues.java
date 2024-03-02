package com.meta;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/find-common-elements-between-two-arrays/description/
 * 2956. Find Common Elements Between Two Arrays Easy
 * You are given two 0-indexed integer arrays nums1 and nums2 of sizes n and m, respectively.
 * Consider calculating the following values:
 * The number of indices i such that 0 <= i < n and nums1[i] occurs at least once in nums2.
 * The number of indices i such that 0 <= i < m and nums2[i] occurs at least once in nums1.
 * Return an integer array answer of size 2 containing the two values in the above order.
 */
public class IntersectionValues {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int x: nums1) set1.add(x);
        for(int y: nums2) set2.add(y);

        int xcount = 0, ycount = 0;
        for(int x: nums1) if( set2.contains(x)) xcount++;
        for(int y: nums2) if( set1.contains(y)) ycount++;
        return new int[]{xcount, ycount};

    }
}
