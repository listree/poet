package com.leet.google;

import java.util.*;
/**
 * https://leetcode.com/problems/range-module/
 * 715. Range Module (Hard)
 * A Range Module is a module that tracks ranges of numbers. Design a data structure to track the ranges represented as
 * half-open intervals and query about them. A half-open interval [left, right) denotes all the real numbers x where left <= x < right.
 * Implement the RangeModule class:
 * RangeModule() Initializes the object of the data structure.
 * void addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval.
 * Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right)
 * that are not already tracked.
 * boolean queryRange(int left, int right) Returns true if every real number in the interval [left, right) is currently being tracked, and false otherwise.
 * void removeRange(int left, int right) Stops tracking every real number currently being tracked in the half-open interval [left, right).
 * Constraints:
 * 1 <= left < right <= 109
 * At most 104 calls will be made to addRange, queryRange, and removeRange.
 * 52 / 54 testcases passed
 */
public class RangeModule {

    public static void main(String[] args) {
        RangeModule ranger = new RangeModule();
//        ranger.addRange(10,20 ); // [10,20)
//        ranger.removeRange(14,16 ); // [10, 14), [16,20)
//        System.out.println(ranger.queryRange(10,14)); // true
//        System.out.println(ranger.queryRange(13,15)); // false
//        System.out.println(ranger.queryRange(16,17)); // true

        // ["RangeModule","addRange","addRange","addRange", "queryRange","queryRange","queryRange","removeRange","queryRange"]
        // [[],           [10,180],  [150,200], [250,500],  [50,100],    [180,300],   [600,1000],  [50,150],     [50,100]
        ranger.addRange(10, 180); // [10,180)
        ranger.addRange(150, 200); // [10,200)
        ranger.addRange(250, 500); // [10,200), [250,500)
        System.out.println(ranger.queryRange(50, 100)); // true
        System.out.println(ranger.queryRange(180, 300)); // false
        System.out.println(ranger.queryRange(600, 1000)); // false
        ranger.removeRange(50, 150); // [10,50), [250,500)
        System.out.println(ranger.queryRange(50, 100)); // false


    }

    TreeSet<Range> sortedRanges;
    public RangeModule() {
        sortedRanges = new TreeSet<Range>();
    }

    // Example: ---------- ---
    //                   ---
    public void addRange(int left, int right) {
        // System.out.println("addRange:" + sortedRanges);
        Set<Range> removingRanges = new HashSet<Range>();
        Range addingRange = new Range(left, right);
        for(Range range: sortedRanges) {
            if( range.containsPoint(left) ) {
                addingRange.left = Math.min(range.left, addingRange.left);
                removingRanges.add(range);
            }
            if( range.containsPoint(right) ) {
                addingRange.right = Math.max(range.right, addingRange.right);
                removingRanges.add(range);
            }
            if( addingRange.containsRange(range) ) {
                removingRanges.add(range);
            }
        }
        sortedRanges.removeAll(removingRanges);
        sortedRanges.add(addingRange);
    }

    // Example: ---------- ---
    //               ---
    public void removeRange(int left, int right) {
        Range removingRange = new Range(left, right);
        Set<Range> newRanges = new HashSet<Range>();
        Set<Range> removingRanges = new HashSet<Range>();
        for( Range range: sortedRanges) {
            if(range.containsPoint(left) ) {
                newRanges.add(new Range(range.left, left));
                removingRanges.add(range);
            }
            if(range.containsPoint(right) ) {
                newRanges.add(new Range(right, range.right));
                removingRanges.add(range);
            }
            if( removingRange.containsRange(range) ) {
                removingRanges.add(range);
            }
        }
        sortedRanges.removeAll(removingRanges);
        sortedRanges.addAll(newRanges);
    }

    public boolean queryRange(int left, int right) {
        // System.out.println("queryRange: " + sortedRanges);
        for( Range range: sortedRanges) {
            if(range.containsPoint(left) ) {
                return range.containsPointRight(right);
            }
        }
        return false;
    }

    private static class Range implements Comparable<Range>{
        public int left;
        public int right;
        Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
        public boolean containsPoint(int p) {
            return this.left <= p && p < this.right;
        }
        public boolean containsPointRight(int p) {
            return this.left <= p && p <= this.right;
        }
        public boolean containsRange(Range that) {
            return this.left <= that.left && that.right <= this.right;
        }

        public int compareTo(Range that) {
            return this.left - that.left;
        }
        public String toString() {
            return left +"," + right;
        }

    }

}
