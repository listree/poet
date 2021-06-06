package com.leetcode.design;

import java.util.*;

/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * 642. Design Search Autocomplete System (Hard)
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with
 * a special character '#').
 * You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously
 * typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character
 * except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.
 * Here are the specific rules:
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences
 * have the same hot degree, use ASCII-code order (smaller one appears first).
 * If less than 3 hot sentences exist, return as many as you can.
 * When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 * Implement the AutocompleteSystem class:
 * AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
 * List<String> input(char c) This indicates that the user typed the character c.
 * Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
 * Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If
 * there are fewer than 3 matches, return them all.
 */
public class HardAutocomplete {

    public final static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        HardAutocomplete obj = new HardAutocomplete(sentences, times);
        System.out.println("input i: " + obj.input('i')); // ["i love you", "island", "i love leetcode"]
        System.out.println("input space: " + obj.input(' ')); // ["i love you", "i love leetcode"]
        System.out.println("input a: " + obj.input('a')); // return []
        System.out.println("input #: " + obj.input('#')); // return []

    }

    // !! Constructor !!!
    public HardAutocomplete(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            insertNode(sentences[i], times[i]);
        }
    }

    public class TrieNode { // TrieNode with extra bits

        public String string;
        public int time;

        public TrieNode[] children = new TrieNode[27]; // support 26 lowercase ascii and space
        public List<TrieNode> top3 = new ArrayList<TrieNode>();

        public void update(TrieNode leaf) {
            if (!top3.contains(leaf)) {
                top3.add(leaf);
                if (top3.size() > 3) {
                    Collections.sort(top3, nodeComparator);
                    top3.remove(top3.size() - 1);
                }
            }
        }
    }

    NodeComparator nodeComparator = new NodeComparator();

    public class NodeComparator implements Comparator<TrieNode> {
        @Override
        public int compare(TrieNode y1, TrieNode y2) {
            int x = y2.time - y1.time;
            if (x != 0)
                return x;
            else
                return y1.string.compareTo(y2.string);
        }
    }

    TrieNode root = new TrieNode();

    private void insertNode(String string, int time) {
        TrieNode node = root;
        for (Character c : string.toCharArray()) {
            int i = (c == ' ') ? 26 : (c - 'a');
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }

        // at end, node is leaf
        TrieNode leaf = node;
        leaf.string = string;
        leaf.time += time;

        // Revisit Tree and update each node by top3
        node = root;
        for (Character c : string.toCharArray()) {
            int i = (c == ' ') ? 26 : (c - 'a');
            node.children[i].update(leaf);
            node = node.children[i];
        }

    }

    TrieNode searchNode = root;
    String searchString = "";

    public List<String> input(char c) {
        List<String> top3 = new ArrayList<String>();
        int i = (c == ' ') ? 26 : (c - 'a');

        if (i < 0 || i > 26) { // restart search
            searchNode = root;
            insertNode(searchString, 1);
            searchString = "";
            return top3;
        }

        searchString += c;

        if (searchNode == null || searchNode.children[i] == null) {
            searchNode = null;
            return top3;
        }

        Collections.sort(searchNode.children[i].top3, nodeComparator);
        for (TrieNode node : searchNode.children[i].top3)
            top3.add(node.string);

        searchNode = searchNode.children[i];
        return top3;
    }

}