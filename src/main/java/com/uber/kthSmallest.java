package com.uber;

import com.leet.*;
import java.util.*;

/** 230. Kth Smallest Element in a BST （Solved）（Medium)
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values
 * of the nodes in the tree.
 */
public class kthSmallest {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        pushStack(stack, root);

        TreeNode node = root;
        while( !stack.isEmpty() ) {
            node = stack.pop();
            k--;
            if( k == 0) {
                break;
            }
            if( node.right != null )
                pushStack(stack, node.right);
        }

        if( k == 0 )
            return node.val;
        else
            return -1;

    }

    void pushStack(Stack<TreeNode> stack, TreeNode root) {
        if( root == null)
            return;

        stack.add(root);

        TreeNode node = root;
        while( node != null) {
            if( node.left != null ) {
                stack.add(node.left);
                node = node.left;
            } else {
                break;
            }
        }
    }

}
