package com.leet.facebook;

import com.leet.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 938. Range Sum of BST (Easy)
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with
 * a value in the inclusive range [low, high].
 * Runtime 0 ms Beats 100%
 * Memory 50.5 MB Beats 15.41%
 */
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if( root == null )
            return 0;

        // root != null
        if( root.val < low ) {
            return rangeSumBST(root.right, low, high);
        }

        if( root.val > high ) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }

}
