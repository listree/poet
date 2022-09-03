package com.leet.facebook;

import com.leet.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 129. Sum Root to Leaf Numbers (Medium)
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * A leaf node is a node with no children.
 * Runtime 0 ms Beats 100%
 * Memory 42.1 MB Beats 18.84%
 */
public class SumToLeaf {

    public final static void main(String[] args) {

        SumToLeaf leetcoder = new SumToLeaf();
        //    4
        //  9   0
        // 5 1
        TreeNode left = new TreeNode(9, new TreeNode(5), new TreeNode(1));
        TreeNode right = new TreeNode(0);
        TreeNode root = new TreeNode(4, left, right);

        System.out.println(leetcoder.sumNumbers(root, 0)); // 1026 ??

    }

    public int sumNumbers(TreeNode root) {
        return  sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int prefix) {

        //System.out.println(root);
        if( root == null )
            return prefix;

        int newPrefix = prefix * 10 + root.val;
        if( root.left == null && root.right == null)
            return newPrefix;

        int leftSum = 0, rightSum = 0;

        if( root.left != null )
            leftSum = sumNumbers(root.left, newPrefix);

        if( root.right != null )
            rightSum = sumNumbers(root.right, newPrefix);

        //System.out.println(leftSum + " - " + rightSum);
        return leftSum + rightSum;

    }


}
