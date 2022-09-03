package com.leet.facebook;

import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 * 528. Random Pick with Weight (Medium)
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive)
 * and returns it. The probability of picking an index i is w[i] / sum(w).
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability
 * of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 * Runtime 373 ms Beats 5.2%
 * Memory 47.7 MB Beats 21.47%
 */
public class RandomPick {

    public static final void main(String[] args) {
        int[] w = {3,14,1,7}; // {3, 17, 18, 25}
        Solution solution = new Solution(w);
        for( int x = 0 ; x < 100; x++) {
            System.out.println("index:" + solution.pickIndex());
        }
    }

    public static class Solution {
        int[] sum;
        int size;
        Random random = new Random();

        public Solution(int[] w) {
            size = w.length;
            for (int i = 1; i < size; i++)
                w[i] = w[i - 1] + w[i];
            sum = w;
        }

        public int pickIndex() {
            int x = random.nextInt(sum[size - 1]);
            //System.out.print("x=" + x + " -> ");
            // 24 -> {3, 17, 18, 25}
            if( x < sum[0] )
                return 0;
            for (int i = 1; i < size; i++) {
                if ( x >= sum[i-1] && x < sum[i]) {
                    return i;
                }
            }
            return size - 1;

        }
    }
}
