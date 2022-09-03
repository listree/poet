package com.walm;

import java.util.*;
import com.leet.*;

/**
 * 863. All Nodes Distance K in Binary Tree (Sovled)
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 */
public class DistanceKNodes {

    public final static void main(String[] args) {
        DistanceKNodes distanceKNodes = new DistanceKNodes();
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(3);
        root.right.right.right.right = new TreeNode(4);
        List<Integer> nodes = distanceKNodes.distanceK(root, root, 2);
        for(int x: nodes) System.out.print(" " + x);

    }

    /**
     * First constructs the tree and then uses DFS to set the parent pointers.
     * After that, it performs BFS to traverse the tree and find nodes at distance K from the target node.
     * The result is a list of node values that meet the criteria.
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // DFS
        HashMap<TreeNode, TreeNode> childParentMap = new HashMap<TreeNode, TreeNode>();
        dfs(root, childParentMap);

        List<Integer> result = new ArrayList<>();

        //BFS
        HashSet<TreeNode> visitedSet = new HashSet<TreeNode>();
        bfs(target, 0, k, result, childParentMap, visitedSet);

        return result;
    }

    private void bfs(TreeNode currentNode, int distance, int k, List<Integer> result, HashMap<TreeNode, TreeNode> map, HashSet<TreeNode> set) {

        if( currentNode == null)
            return;

        if( !set.contains(currentNode) )
            set.add(currentNode);
        else
            return;

        if( distance == k ) {
            result.add(currentNode.val);
            return;
        }

        if( currentNode.left != null)
            bfs(currentNode.left, distance+1, k, result, map, set);

        if( currentNode.right != null)
            bfs(currentNode.right, distance+1, k, result, map, set);

        if( map.get(currentNode) != null)
            bfs(map.get(currentNode), distance+1, k, result, map, set);


    }

    private void dfs(TreeNode root, HashMap<TreeNode, TreeNode> childParentMap) {
        if( root == null )
            return;

        if( root.left != null ) {
            childParentMap.put(root.left, root);
            dfs(root.left, childParentMap);
        }

        if( root.right != null ) {
            childParentMap.put(root.right, root);
            dfs(root.right, childParentMap);
        }

    }



}
