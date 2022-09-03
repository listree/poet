package com.leet.facebook;

import java.util.*;

import com.leet.TreeNode;
import com.leet.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 199. Binary Tree Right Side View (Medium)
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 * Runtime 1 ms Beats 80.39%
 * Memory 40.7 MB Beats 96.54%
 */
public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if( root == null )
            return result;

        queue.add(root);
        queue.add(null);
        int last = root.val;
        while( !queue.isEmpty() ) {
            TreeNode node = queue.pop();
            if( node != null ) {
                last = node.val;
                if( node.left != null)
                    queue.add(node.left);
                if( node.right != null)
                    queue.add(node.right);
            } else {
                result.add(last);
                if( !queue.isEmpty() )
                     queue.add(null);
            }
        }

        return result;
    }

}
