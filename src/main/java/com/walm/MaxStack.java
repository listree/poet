package com.walm;

import java.util.*;

/**
 * 716. Max Stack
 * Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
 * Implement the MaxStack class:
 * MaxStack() Initializes the stack object.
 * void push(int x) Pushes element x onto the stack.
 * int pop() Removes the element on top of the stack and returns it.
 * int top() Gets the element on the top of the stack without removing it.
 * int peekMax() Retrieves the maximum element in the stack without removing it.
 * int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 * You must come up with a solution that supports O(1) for each top call and O(logn) for each other call.
 */
public class MaxStack {
    public final static void main(String[] args) {
        MaxStack stk = new MaxStack();
        stk.push(5);   // [5] the top of the stack and the maximum number is 5.
        stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        System.out.println(stk.top());     // return 5, [5, 1, 5] the stack did not change.
        System.out.println(stk.popMax());  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        System.out.println(stk.top());     // return 1, [5, 1] the stack did not change.
        System.out.println(stk.peekMax()); // return 5, [5, 1] the stack did not change.
        System.out.println(stk.pop());     // return 1, [5] the top of the stack and the max element is now 5.
        System.out.println(stk.top());     // return 5, [5] the stack did not change.
    }

    Stack<Node> stack;
    PriorityQueue<Node> queue;
    int sequence;

    public MaxStack() {
        stack = new Stack<Node>();
        queue = new PriorityQueue<Node>();
        sequence = 0;
    }

    public void push(int x) {
        Node node = new Node(x, sequence++);
        stack.push(node);
        queue.add(node);
    }

    public int pop() {
        Node node = stack.pop();
        queue.remove(node);
        return node.value;
    }

    public int top() {
        System.out.println(stack);
        return stack.peek().value;
    }

    public int peekMax() {
        return queue.peek().value;
    }

    public int popMax() {
        Node node = queue.poll();
        stack.remove(node);
        return node.value;
    }

    class Node implements Comparable<Node>{
        int value;
        int order;
        Node(int v, int o) {
            value = v;
            order = o;
        }

        public int compareTo(Node that) {
            if( that.value == this.value )
               return that.order - this.order;
            else
                return that.value - this.value;
        }
    }

}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
