package com.uber;

import com.amazonaws.services.dynamodbv2.model.transform.ScanResultJsonUnmarshaller;

/**
 * 55. Jump Game (Medium) (Solved)
 * https://leetcode.com/problems/jump-game/description/
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {

    public final static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        System.out.println( jumpGame.canJump(nums) );

    }

    public boolean canJump(int[] nums) {


        boolean[] jumpables = new boolean[nums.length];
        jumpables[nums.length-1] = true;
        for( int i = nums.length - 2; i > -1; i--) {
            jumpables[i] = checkJump(nums[i], i, jumpables);
        }

        return jumpables[0];

    }

    private boolean checkJump(int step, int start, boolean[] jumpables) {
        for( int i = 1; i <= step; i++) {
            if( (start + i) >= jumpables.length ) {
                return false;
            }
            if( jumpables[start + i] )
                return true;
        }
        return false;
    }

}
