package com.walm;

/**
 * 1052. Grumpy Bookstore Owner Solved Medium
 * https://leetcode.com/problems/grumpy-bookstore-owner/description/
 *
 * There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
 * You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
 * On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
 * When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
 * The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
 * Return the maximum number of customers that can be satisfied throughout the day.
 */
public class GrumpBookstore {
    // Unsolved
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int max = 0;
        int n = customers.length;
        for(int i = 0; i < n; i++) {
            int sum = 0 ;
            for(int j = 0; j < minutes; j++) {
                if( (i + j) < n ) {
                    if( grumpy[i+j] == 1)
                        sum += customers[i+j];
                }
            }
            max = Math.max(max, sum);
        }

        int satisfy = 0 ;
        for(int i = 0; i < n; i++) {
            if( grumpy[i] != 1 )
                satisfy += customers[i];
        }
        return satisfy + max;

    }
}
