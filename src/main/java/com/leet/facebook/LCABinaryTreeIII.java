package com.leet.facebook;
import java.util.*;

/**
 * 1650. Lowest Common Ancestor of a Binary Tree III (Medium)
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 * Each node will have a reference to its parent node. The definition for Node is below:
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is
 * the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
 * Runtime 24 ms Beats 55.13%
 * Memory 43.2 MB Beats 64.98%
 */

public class LCABinaryTreeIII {

    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> ancestorsP = new HashSet<Node>();
        while( p != null ) {
            ancestorsP.add(p);
            p = p.parent;
        }

        while( q != null ) {
            if( ancestorsP.contains(q) )
                return q;
            q = q.parent;
        }

        return null;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

}
