package com.leet.diehard;

import java.util.*;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 315. Count of Smaller Numbers After Self (Hard)
 * Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to
 * the right of nums[i].
 * Use Binary search Tree Solution: Time Limit Exceeded
 * Use Binary indexed Tree (Fenwick Tree)
 */
public class CountSmallerAfter {

    public static void main(String[] args) {
        CountSmallerAfter ha = new CountSmallerAfter();
        int[] nums = {5, 2, 6, 1};
        List result = ha.countSmaller(nums);
        // result: [2, 1, 1, 0]
        System.out.println(result);

    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length ==0)
            return list;

        BSTNode root = new BSTNode(nums[nums.length-1]);
        list.add(0);

        for(int i = nums.length-2; i >=0; i--) {
            int count = insertBSTNode(root, nums[i]);
            list.add(0, count);
        }

        return list;

    }

    public class BSTNode { //  BST TreeNode with count

        public int value;
        public int count = 1;
        public BSTNode left;
        public BSTNode right;

        BSTNode(int value) {
           this.value = value;
        }
    }
    int insertBSTNode(BSTNode root, int val) {
        BSTNode node = root;
        new BSTNode(val);
        int count = 0;
        while (node != null ) {
            if( val <= node.value) { // Left
                node.count++;
                if(node.left != null)
                    node = node.left;
                else {
                    node.left = new BSTNode(val);
                    break;
                }
            } else { // Right
                count += node.count;
                if( node.right != null ) {
                    node = node.right;
                } else {
                    node.right = new BSTNode(val);
                    break;
                }
            }
        }
        return count;

    }

}
