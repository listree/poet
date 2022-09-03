package com.leet.amazon;

import java.util.*;


/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 138. Copy List with Random Pointer (Medium)
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the
 * value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * Runtime: 1 ms, faster than 43.48% of Java online submissions for Copy List with Random Pointer.
 * Memory: 44.8 MB, less than 82.95% of Java online submissions for Copy List with Random Pointer.
 */
public class MediumCopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if( head == null )
            return null;

        Node newHead = new Node(head.val);
        HashMap<Node, Node> map = new  HashMap<Node, Node>();
        map.put(head, newHead);

        Node oldCurrent = head;
        Node newCurrent = newHead;

        // copy without randome
        while( oldCurrent.next != null ) {
            newCurrent.next = new Node(oldCurrent.next.val);
            map.put(oldCurrent.next, newCurrent.next);
            oldCurrent = oldCurrent.next;
            newCurrent = newCurrent.next;
        }

        // link random node
        oldCurrent = head;
        newCurrent = newHead;
        while( oldCurrent != null ) {
            newCurrent.random = map.get(oldCurrent.random);
            oldCurrent = oldCurrent.next;
            newCurrent = newCurrent.next;
        }

        return newHead;

    }
}
