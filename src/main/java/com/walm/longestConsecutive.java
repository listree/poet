package com.walm;

import com.leet.*;

/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence
 * 298. Binary Tree Longest Consecutive Sequence Medium
 * Given the root of a binary tree, return the length of the longest consecutive sequence path.
 * A consecutive sequence path is a path where the values increase by one along the path.
 * Note that the path can start at any node in the tree, and you cannot go from a node to its parent in the path.
 */
public class longestConsecutive {

    public int longestConsecutive(TreeNode root) {

        if( root == null )
            return 0;

        Counter counter = new Counter();
        longestStartSoFar(root, 0, root.val, counter);
        return counter.count;

    }

    private void longestStartSoFar(TreeNode root,
                                   int curlength,
                                   int nextExpected,
                                   Counter counter)
    {
        if (root == null)
            return;

        if (root.val == nextExpected)
            curlength++;
        else
            curlength = 1; // reset

        // update the maximum by current length
        counter.count = Math.max(counter.count, curlength);

        // recursively call left and right subtree with expected value 1 more than root data
        longestStartSoFar(root.left, curlength, root.val + 1, counter);
        longestStartSoFar(root.right, curlength, root.val + 1, counter);
    }


    class Counter {
        int count;
    }

}
