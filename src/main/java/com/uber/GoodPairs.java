package com.uber;

import java.util.*;

/**
 * 1512. Number of Good Pairs (Easy)
 * https://leetcode.com/problems/number-of-good-pairs/
 */
public class GoodPairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int x: nums ) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int total = 0 ;
        for(int v : map.values() ) {
            if( v > 1) {
                total += v * (v -1) / 2 ;
            }
        }

        return total;
    }
}
