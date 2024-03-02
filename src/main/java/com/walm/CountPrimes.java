package com.walm;

/**
 * 204. Count Primes Solved Medium
 * https://leetcode.com/problems/count-primes/description/
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 */
public class CountPrimes {

    public int countPrimes(int n) {

        if( n <= 2)
            return 0;

        int count  = 0;
        boolean[] prime = new boolean[n];

        for( int i = 2; i < n ; i++) {
            prime[i] = true;
        }

        for( int i = 2; i < n; i++) {
            if( prime[i] ) {
                count++;
                for( int j = 2; j * i < n; j++) {
                    prime[j*i] = false;
                }
            }
        }
        return count;
    }

}
