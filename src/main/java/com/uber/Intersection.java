package com.uber;

import java.util.ArrayList;

/**
 * 986. Interval List Intersections
 * https://leetcode.com/problems/interval-list-intersections/description/
 * You are given two lists of closed intervals, firstList and secondList, where firstList{i} = {starti, endi}
 * and secondList{j} = {startj, endj}. Each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * A closed interval {a, b} (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
 * For example, the intersection of {1, 3} and {2, 4} is {2, 3}.
 */
public class Intersection {

    public final static void main(String[] args) {
        Intersection intervalIntersection = new Intersection();
        int[][] firstList = {{0, 2},{5, 10},{13, 23},{24, 25}};
        int[][] secondList = {{1, 5},{8, 12},{15, 24},{25, 26}};
        int[][] result = intervalIntersection.intervalIntersection(firstList, secondList);
        //Output: {{1, 2},{5, 5},{8, 10},{15, 23},{24, 24},{25, 25}}
        for(int i = 0 ; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }


    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {


        if(firstList == null || firstList.length == 0 ||
                secondList == null || secondList.length == 0) {
            return new int[0][];
        }

        ArrayList<int[]> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while( p1 < firstList.length && p2 < secondList.length ) {

            int[] intersect = checkIntersect(firstList[p1], secondList[p2]);
            if( intersect == null ) {
                if( firstList[p1][0] < secondList[p2][0] ) {
                    p1++;
                } else
                    p2++;
            } else {
                list.add(intersect);
                if( firstList[p1][1] == intersect[1]) {
                    p1++;
                } else
                    p2++;
            }
        }

        int[][] result = new int[(list.size())][];
        for( int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }

    private int[] checkIntersect(int[] t1, int[] t2) {

        int start = Math.max(t1[0], t2[0]);
        int end = Math.min(t1[1], t2[1]);

        if( start <= end )
            return new int[]{start, end};
        else
            return null;
    }

}
