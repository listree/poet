package com.leet.google;

import com.leet.TreeNode;
import java.util.*;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * 662. Maximum Width of Binary Tree (Medium)
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes that would be present in a complete binary tree extending down to
 * that level are also counted into the length calculation.
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 * Runtime: 4 ms, faster than 40.15% of Java online submissions for Maximum Width of Binary Tree.
 * Memory Usage: 44.8 MB, less than 6.13% of Java online submissions for Maximum Width of Binary Tree.
 */
public class BinaryTreeWidth {

    public static void main(String[] args) {
        //           1,
        //      3,       2,
        //    5, 4,  null,  9
        // null, null, null, null, null, null, null
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);

        TreeNode node3 = new TreeNode(3, node5, node4);
        TreeNode node2 = new TreeNode(2, null, node9);
        TreeNode root = new TreeNode(1, node3, node2);

        BinaryTreeWidth coder = new BinaryTreeWidth();
        System.out.println( coder.widthOfBinaryTree(root) );

    }

    int maxWidth = 0;
    HashMap<Integer, Integer> leftMostMap = new HashMap<Integer, Integer>();
    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        leftMostMap = new HashMap<Integer, Integer>();
        widthOfBinaryTree(root, 0, 0);
        return maxWidth;
    }

    private void widthOfBinaryTree(TreeNode root, int depth, int position) {
        if( root == null )
            return;

        if( !leftMostMap.containsKey(depth) )
            leftMostMap.put(depth, position);

        maxWidth = Math.max(maxWidth, position - leftMostMap.get(depth) + 1);

        widthOfBinaryTree(root.left, depth + 1, position * 2);
        widthOfBinaryTree(root.right, depth + 1, position * 2 + 1);

    }

}
