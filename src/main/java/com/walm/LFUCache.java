package com.walm;

import java.util.*;

/**
 * 460. LFU Cache (Hard)
 * https://leetcode.com/problems/lfu-cache/description/
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 * Implement the LFUCache class:
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 *
 * When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item.
 * For this problem, when there is a tie (i.e., two or more keys with the same frequency),
 * the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache.
 * The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 */
class LFUCache {

    public final static void main(String[] args) {

        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        // lfu.printSortedSet();
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        // lfu.printSortedSet();
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3

    }

    public void printSortedSet() {
        for(Node node: set.descendingSet()) {
            System.out.println(node);
        }
    }

    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    TreeSet<Node> set = new TreeSet<Node>();
    int capacity;
    int globalTime;

    public LFUCache(int c) {
        map = new HashMap<Integer, Node>();
        capacity = c;
        globalTime = 0;
    }

    public int get(int key) {
        if( map.containsKey(key) ) {
            Node node = map.get(key);
            set.remove(node);
            node.counter++;
            globalTime++;
            node.timestamp = globalTime;
            set.add(node);
            return node.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {

        if( map.containsKey(key) ) {
            Node node = map.get(key);
            set.remove(node);
            node.value = value;
            node.counter++;
            globalTime++;
            node.timestamp = globalTime;
            set.add(node);
        } else {

            // check reach capacity
            // System.out.println("check capacity:" + map.size() + ">=" + capacity);
            if( map.size() >= capacity ) {
                // Find the least frequently used key
                Node deletingNode = set.first();
                // System.out.println("invalidate: " + deletingNode.key);
                map.remove(deletingNode.key);
                set.remove(deletingNode);
            }

            // inserting a new item
            // System.out.println("inserting a new item:" + key + "->" + value);
            Node node = new Node(key, value);
            globalTime++;
            node.timestamp = globalTime;
            map.put(key, node);
            set.add(node);
        }

    }

    class Node implements Comparable<Node>{
        int key;
        int value;
        int counter;
        int timestamp;

        Node(int k, int v) {
            key = k;
            value = v;
            counter = 1;
        }

        public int compareTo(Node that) {
            if( this.counter != that.counter )
                return this.counter - that.counter;
            else
                return this.timestamp - that.timestamp;
        }

        public String toString() {
            return "" + key + "->" + value + "->" + counter + "->" +timestamp;
        }

    }

}
