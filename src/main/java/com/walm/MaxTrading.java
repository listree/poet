package com.walm;

/**
 * 2291. Maximum Profit From Trading Stocks
 * You are given two 0-indexed integer arrays of the same length present and future where present[i] is
 * the current price of the ith stock and future[i] is the price of the ith stock a year in the future.
 * You may buy each stock at most once. You are also given an integer budget representing the amount of money you currently have.
 * Return the maximum amount of profit you can make.
 */
public class MaxTrading {

    public final static void main(String[] args) {
        int[] present = {5,4,6,2,3};
        int[] future  = {8,5,4,3,5};
        int budget = 10;
        MaxTrading maxTrading = new MaxTrading();
        System.out.println(maxTrading.maximumProfit(present, future, budget));


    }

    public int maximumProfit(int[] present, int[] future, int budget) {
        return maximumProfit(present, future, budget, present.length-1);
    }

    public int maximumProfit(int[] present, int[] future, int budget, int endIndex) {

        if( endIndex == 0 ) {
            if( present[0] <= budget )
                return Math.max(0, future[0] - present[0]);
            else
                return 0;
        }


        if( present[endIndex] <= budget ) {
            int maxBeforeWithEnd = maximumProfit(present, future, budget - present[endIndex], endIndex - 1);
            int maxBeforeWithoutEnd = maximumProfit(present, future, budget, endIndex - 1);

            int max = Math.max(
                    maxBeforeWithEnd + future[endIndex] - present[endIndex],
                    maxBeforeWithoutEnd
                    );
            return max;

        } else {
            int max = maximumProfit(present, future, budget, endIndex - 1);
            return max;
        }

    }

}
