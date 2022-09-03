package com.leet.facebook;

import java.util.*;

import com.leet.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 * 314. Binary Tree Vertical Order Traversal (Medium)
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values.
 * (i.e., from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * Runtime 4 ms Beats 36.61%
 * Memory 42.5 MB Beats 68.91%
 */
public class VerticalTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        levelTraversal(root, map);
        return new ArrayList<List<Integer>>(map.values());

    }

    private void levelTraversal(TreeNode root, TreeMap<Integer, List<Integer>> map) {
        if( root == null )
            return;

        HashMap<TreeNode, Integer> hash = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int index = 0;
        List<Integer> list = map.getOrDefault(index, new ArrayList<Integer>());
        map.put(index, list);
        list.add(root.val);
        queue.add(root);
        hash.put(root, 0);

        while( !queue.isEmpty() ) {
            TreeNode node = queue.poll();
            index = hash.get(node);

            if (node.left != null) {
                List<Integer> left = map.getOrDefault(index-1, new ArrayList<Integer>());
                map.put(index-1, left);
                left.add(node.left.val);
                queue.add(node.left);
                hash.put(node.left, index-1);
            }

            if (node.right != null) {
                List<Integer> right = map.getOrDefault(index+1, new ArrayList<Integer>());
                map.put(index+1, right);
                right.add(node.right.val);
                queue.add(node.right);
                hash.put(node.right, index+1);
            }

        }

    }

}
