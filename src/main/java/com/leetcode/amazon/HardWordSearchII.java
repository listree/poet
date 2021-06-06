package com.leetcode.amazon;

import com.leetcode.TrieNode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/
 * 212. Word Search II (Hard)
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once in a word.
 * Runtime: 457 ms, faster than 42.10% of Java online submissions for Word Search II.
 * Memory: 44.3 MB, less than 59.07% of Java online submissions for Word Search II.
 */
public class HardWordSearchII {

    public final static void main(String[] args) {

        HardWordSearchII ha = new HardWordSearchII();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(ha.findWords(board, words));  // Output: ["eat","oath"]

        char[][] board2 = {{'a','a'}};
        String[] words2 = {"aaa"};
        System.out.println(ha.findWords(board2, words2));  // Output: []

        char[][] board3 = {
                {'o','a','b','n'},
                {'o','t','a','e'},
                {'a','h','k','r'},
                {'a','f','l','v'}};
        String[] words3 = {"oa", "oaa"};
        System.out.println(ha.findWords(board3, words3));  // ["oa","oaa"]

        char[][] board4 = {{'a','a'},{'a','a'}};
        String[] words4 = {"aaaaa"};
        System.out.println(ha.findWords(board4, words4));  // []

    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<String>();
        TrieNode root = new TrieNode();
        for(String word: words) {
            addTrie(root, word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, root, i, j, set, visited);
            }
        }
        return new ArrayList<String>(set);
    }

    void addTrie(TrieNode root, String word) {
        TrieNode node = root;
        for( char c : word.toCharArray()) {
            int index = c - 'a';
            if( node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
        node.word = word;
    }

    void search(char[][] board, TrieNode root, int i, int j, Set<String> set, boolean[][] visited) {

        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        if( visited[i][j] ) {
            return;
        }

        visited[i][j] = true;
        char c = board[i][j];
        TrieNode node = root.children[ c - 'a'];
        if( node == null) {
            visited[i][j] = false;
            return;
        }

        if( node.isWord )
            set.add(node.word);

        search(board, node, i+1, j, set, visited);
        search(board, node, i-1, j, set, visited);
        search(board, node, i, j-1, set, visited);
        search(board, node, i, j+1, set, visited);
        visited[i][j] = false;

    }
}
