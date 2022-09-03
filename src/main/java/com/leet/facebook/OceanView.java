package com.leet.facebook;

import java.util.*;

/**
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 * 1762. Buildings With an Ocean View (Medium)
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions.
 * Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 * Runtime 336 ms Beats 6.49%
 * Memory 53.7 MB Beats 95.96%
 */
public class OceanView {

    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<Integer>();
        list.add(n-1);
        int max = heights[n - 1];
        for(int i = heights.length - 2 ; i > -1 ; i--) {
            if( max < heights[i] ) {
                max = heights[i];
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for( int i = 0 ; i < list.size(); i++ )
            result[i] = list.get(i);

        return result;
    }

}
