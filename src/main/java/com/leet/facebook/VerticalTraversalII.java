package com.leet.facebook;

import java.util.*;

import com.leet.TreeNode;
import com.leet.*;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * 987. Vertical Order Traversal of a Binary Tree (Hard)
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1)
 * and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting
 * from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column.
 * In such a case, sort these nodes by their values.
 * Return the vertical order traversal of the binary tree.
 */
public class VerticalTraversalII {

    //      3
    //   1      4
    // 0 2    2

    public final static void main(String[] args) {
        VerticalTraversalII leet = new VerticalTraversalII();

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> rightList = new ArrayList<List<Integer>>();
        List<List<Integer>> leftList = new ArrayList<List<Integer>>();
        leftList.add(new ArrayList<>());
        // start from root
        process(root, 0, 0, rightList, leftList);
        leftList.remove(0);
        Collections.reverse(leftList);
        leftList.addAll(rightList);
        return leftList;
    }

    void process(TreeNode root, int row, int col,  List<List<Integer>> rightList, List<List<Integer>> leftList) {
        if (root == null)
            return;

        if (col >= 0) {
            if (rightList.size() <= col)
                rightList.add(new ArrayList());
            List<Integer> list = rightList.get(col);
            int i = 0;
            while ( i < list.size() && root.val > list.get(i)) {
                i++;
            }
            list.add(i, root.val);
        }

        if (col < 0) {
            // insert to right list
            if (leftList.size() <= -col)
                leftList.add(new ArrayList());
            List<Integer> list = leftList.get(-col);
            int i = 0;
            while ( i < list.size() && root.val > list.get(i)) {
                i++;
            }
            list.add(i, root.val);
        }

        process(root.left,row + 1,col - 1, rightList, leftList);
        process(root.right,row + 1,col + 1, rightList, leftList);

    }

}
