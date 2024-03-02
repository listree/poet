package com.meta;

import com.leet.*;
import java.util.*;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 * 1161. Maximum Level Sum of a Binary Tree Medium Accepted
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSum {

    public int maxLevelSum(TreeNode root) {

        if( root == null)
            return  0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        int maxSum = root.val;
        int maxLevel = 1;

        int currentLevel = 1;
        int currentSum =  0;
        while( !queue.isEmpty() ) {
            TreeNode node = queue.poll();
            if( node != null ) {
                currentSum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                continue;
            }

            if( node == null ) {
                // end of level
                if( maxSum < currentSum ) {
                    maxLevel = currentLevel;
                    maxSum = currentSum;
                }
                if( queue.isEmpty() ) {  // last level over
                    break;
                } else { // more level to go, reset currentSum
                    currentLevel++;
                    currentSum = 0 ;
                    queue.add(null);
                }
            }
        }

        return maxLevel;
    }

}
