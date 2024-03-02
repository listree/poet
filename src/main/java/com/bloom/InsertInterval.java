package com.bloom;

import java.util.*;

/**
 * 57. Insert Interval Solved Medium
 * https://leetcode.com/problems/insert-interval/description/
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still
 * does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<int[]>();

        for(int[] interval: intervals) {
            if( interval[0] > newInterval[1] ) {
                list.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                list.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        list.add(newInterval);
        return list.toArray(new int[list.size()][]);

    }

}
