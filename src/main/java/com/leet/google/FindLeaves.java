package com.leet.google;

import com.leet.TreeNode;
import java.util.*;


/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this: (Medium)
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 * Runtime: 1 ms, faster than 79.36% of Java online submissions for Find Leaves of Binary Tree.
 * Memory Usage: 42.3 MB, less than 65.02% of Java online submissions for Find Leaves of Binary Tree.
 */
public class FindLeaves {

    public final static void main(String[] args) {
        // root = [1,2,3,4,5]
        // Output: [[4,5,3],[2],[1]]
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);

        FindLeaves leeter = new FindLeaves();
        System.out.println( leeter.findLeaves(root) );
    }

    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        boolean stop = false;
        while( !stop ) {
            List<Integer> list = new ArrayList<Integer>();
            stop = findLeaves(root, list);
            result.add(list);
        }

        return result;

    }

    private boolean findLeaves(TreeNode node, List<Integer> result) {
        if( node == null )
            return true;

        if( isLeaf(node) ) {
            result.add(node.val);
            return true;
        }

        if( node.left != null ) {
            if(isLeaf(node.left) ) {
                result.add(node.left.val);
                node.left = null;
            } else {
                findLeaves(node.left, result);
            }
        }

        if( node.right != null ) {
            if(isLeaf(node.right) ) {
                result.add(node.right.val);
                node.right = null;
            } else {
                findLeaves(node.right, result);
            }
        }

        return false;

    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
