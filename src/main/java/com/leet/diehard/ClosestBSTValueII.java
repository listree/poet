package com.leet.diehard;

import java.util.*;
import com.leet.TreeNode;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/
 * 272. Closest Binary Search Tree Value II (Hard)
 * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST
 * that are closest to the target. You may return the answer in any order.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Runtime: 4 ms, faster than 58.41% of Java online submissions for Closest Binary Search Tree Value II.
 * Memory: 45.6 MB, less than 32.13% of Java online submissions for Closest Binary Search Tree Value II.
 */
public class ClosestBSTValueII {
    public static void main(String[] args) {
        ClosestBSTValueII ha = new ClosestBSTValueII();
        /**     4
         *    2  5
         *  1  3
         */
        TreeNode root = new TreeNode(4, 2, 5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        // output: [3,4]
        System.out.println(ha.closestKValues(root, 3.714286, 2));
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        Stack<Integer> smallerStack =  new Stack<>();
        Stack<Integer> biggerStack =  new Stack<>();

        inorderSmaller(root, target, smallerStack);
        inorderBigger(root, target, biggerStack);

        List<Integer> result = new ArrayList<>();

        int count = 0;
        while( count < k) {
            if(smallerStack.isEmpty())
                result.add(biggerStack.pop());
            else if (biggerStack.isEmpty())
                result.add(smallerStack.pop());
            else {
                if(Math.abs(smallerStack.peek() - target) < Math.abs(biggerStack.peek() - target))
                    result.add(smallerStack.pop());
                else
                    result.add(biggerStack.pop());
            }
            count++;
        }

        return result;
    }

    private void inorderSmaller(TreeNode root, double target, Stack smallerStack) {
        if( root == null) return;

        inorderSmaller(root.left, target, smallerStack);

        if( root.val > target) return;
        smallerStack.push(root.val);

        inorderSmaller(root.right, target, smallerStack);
    }

    private void inorderBigger(TreeNode root, double target, Stack biggerStack) {
        if( root == null) return;

        inorderBigger(root.right, target, biggerStack);

        if( root.val <= target) return;
        biggerStack.push(root.val);

        inorderBigger(root.left, target, biggerStack);

    }

}
