package com.meta;

import java.util.*;
import com.leet.*;

/**
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * 545. Boundary of Binary Tree Medium ???
 * The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.
 * The left boundary is the set of nodes defined by the following:
 * The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty.
 * If a node in the left boundary and has a left child, then the left child is in the left boundary.
 * If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.
 * The leftmost leaf is not in the left boundary.
 * The right boundary is similar to the left boundary, except it is the right side of the root's right subtree.
 * Again, the leaf is not part of the right boundary, and the right boundary is empty if the root does not have a right child.
 *
 * The leaves are nodes that do not have any children. For this problem, the root is not a leaf.
 *
 * Given the root of a binary tree, return the values of its bounda
 */
public class BoundaryOfBinaryTree {
    public final static void main(String[] args) {
        BoundaryOfBinaryTree boundaryOfBinaryTree = new BoundaryOfBinaryTree();
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode node1 = new TreeNode(1, null, node2);
        List<Integer> boundary = boundaryOfBinaryTree.boundaryOfBinaryTree(node1);
        System.out.println(boundary); // [1, 3, 2, 4]

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> wholeBoundary = new ArrayList<>();
        if (root == null)
            return wholeBoundary;
        else
            wholeBoundary.add(root.val);

        if( root.left == null && root.right == null)
            return wholeBoundary;

        // left boundary
        List<Integer> leftBoundary = new ArrayList<>();
        findLeftBoundary(root, leftBoundary, true);
        System.out.println(leftBoundary);
        wholeBoundary.addAll(leftBoundary);

        // leaves
        List<Integer> leaves = new ArrayList<>();
        findLeaves(root, leaves);
        System.out.println(leaves);
        wholeBoundary.addAll(leaves);

        // right boundary
        List<Integer> rightBoundary = new ArrayList<>();
        findRightBoundary(root, rightBoundary, true);
        System.out.println(rightBoundary);
        Collections.reverse(rightBoundary);
        wholeBoundary.addAll(rightBoundary);
        return wholeBoundary;
    }

    private void findLeaves(TreeNode root, List<Integer> leaves) {

        if( root == null)
            return;

        if( root.left == null && root.right == null ) {
            leaves.add(root.val);
            return;
        }

        if( root.left != null )
            findLeaves(root.left, leaves);

        if( root.right != null )
            findLeaves(root.right, leaves);

    }

    private void findLeftBoundary(TreeNode root, List<Integer> leftBoundary, boolean first) {
        if( root.left != null ) {
            if (root.left.left == null && root.left.right == null) { // it's leaf, terminate
                return;
            }
            else {
                leftBoundary.add(root.left.val);
                findLeftBoundary(root.left, leftBoundary, false);
            }
        } else {
            if( !first && root.right != null && (root.right.left !=null || root.right.right !=null)) {
                leftBoundary.add(root.right.val);
                findLeftBoundary(root.right, leftBoundary, false);

            }
        }
    }

    private void findRightBoundary(TreeNode root, List<Integer> rightBoundary, boolean first) {
        if( root.right != null ) {
            if (root.right.left == null && root.right.right == null) { // terminate on leaf
                return;
            }
            else {
                rightBoundary.add(root.right.val);
                findRightBoundary(root.right, rightBoundary, false);
            }
        } else {
            if( !first && root.left != null && (root.left.left != null || root.left.right != null)) {
                rightBoundary.add(root.left.val);
                findRightBoundary(root.left, rightBoundary, false);
            }
        }
    }

}
