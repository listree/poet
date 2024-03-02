package com.uber;

/**
 * 70. Climbing Stairs (Easy)
 * https://leetcode.com/problems/climbing-stairs/description/
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {

    public int climbStairs(int n) {

        if (n == 0)
            return 1;

        if (n == 1)
            return 1;

        int n0 = 1;
        int n1 = 1;

        for( int i = 2; i <= n; i++) {
            int n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return n1;
    }

}
