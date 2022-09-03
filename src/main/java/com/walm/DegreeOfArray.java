package com.walm;

import java.util.HashMap;

/**
 * 697. Degree of an Array
 * https://leetcode.com/problems/degree-of-an-array/description/
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 */
public class DegreeOfArray {

    public final static void main(String[] args) {
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(degreeOfArray.findShortestSubArray(nums));

    }
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Record> map = new HashMap<Integer, Record>();
        int degree  = 0;
        for(int i =0; i < nums.length; i++) {
            if( map.containsKey(nums[i]) ) {
                Record r = map.get(nums[i]);
                r.count++;
                r.end = i;
                degree = Math.max(degree, r.count);
            } else {
                Record r = new Record();
                r.start = i;
                r.end = i;
                r.count = 1;
                degree = Math.max(degree, r.count);
                map.put(nums[i], r);
            }
        }

        int minSub = Integer.MAX_VALUE;
        for( int x: map.keySet() ) {
            Record r = map.get(x);
            if( r.count == degree ) {
                minSub = Math.min(minSub, r.end - r.start + 1);
            }
        }

        return minSub;
    }

    class Record {
        int start;
        int end;
        int count;
    }

}
