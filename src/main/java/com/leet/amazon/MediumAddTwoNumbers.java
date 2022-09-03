package com.leet.amazon;

import com.leet.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *  2. Add Two Numbers (Medium)
 *  You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order, and each of their nodes contains a single digit.
 *  Add the two numbers and return the sum as a linked list.
 *  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Runtime: 3 ms, faster than 80.44% of Java online submissions for Add Two Numbers.
 *  Memory: 48 MB, less than 33.44% of Java online submissions for Add Two Numbers.
 */
public class MediumAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int v = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val);
        ListNode root = new ListNode(v % 10);
        int extra = v / 10;
        ListNode preNode = root;
        if( l1 != null )
            l1 = l1.next;

        if( l2 != null )
            l2 = l2.next;

        while( l1 != null || l2 != null ) {

            v = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + extra;
            ListNode newNode = new ListNode(v % 10);
            extra = v /10;
            preNode.next = newNode;
            preNode = newNode;

            if( l1 != null )
                l1 = l1.next;
            if( l2 != null )
                l2 = l2.next;

        }

        if( extra != 0) {
            ListNode newNode = new ListNode(extra);
            preNode.next = newNode;
        }

        return root;

    }
}
