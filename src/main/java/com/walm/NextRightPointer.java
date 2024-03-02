package com.walm;

import java.util.*;

/**
 * 116. Populating Next Right Pointers in Each Node Solved Medium
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 */
public class NextRightPointer {

    public final static void main(String[] args) {
        NextRightPointer nextRightPointer = new NextRightPointer();
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node6, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);

        Node result = nextRightPointer.connect(node1);
        System.out.println(node1.next);
        System.out.println(node3.next);
        System.out.println(node7.next);

    }

    public Node connect(Node root) {

        if( root == null )
            return null;

        Node marker = new Node(0);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(marker);

        Node pre = null;

        while( !queue.isEmpty() ) {
            Node current = queue.poll();
            if( current == marker ) {
                if( queue.isEmpty() ) {
                    pre.next = null;
                    break;
                } else {
                    queue.add(marker);
                    pre.next = null;
                    pre = null;
                    continue;
                }
            }

            if( pre != null )
                pre.next = current;

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);

            pre = current;

        }

        return root;

    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
