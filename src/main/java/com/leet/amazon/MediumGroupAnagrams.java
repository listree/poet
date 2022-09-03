package com.leet.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 * 49. Group Anagrams (Medium)
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * Runtime: 114 ms, faster than 6.45% of Java online submissions for Group Anagrams.
 * Memory: 74.7 MB, less than 5.05% of Java online submissions for Group Anagrams.
 */
public class MediumGroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs) {
            String formalized = formalize(str);
            List<String> list = map.getOrDefault(formalized, new ArrayList<String>());
            list.add(str);
            map.put(formalized, list);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for( List<String> list: map.values()) {
            result.add(list);
        }
        return result;
    }

    String formalize(String str) {
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        for(char c: str.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        String formalized = "";
        // if map keeps order, then should work. otherwise, scan a -> z
        for( int i = 0; i < 26; i++ ) {
            char c = (char) ('a' + i);
            if( chars.containsKey(c) ) {
                formalized += c;
                formalized += "" + chars.get(c);
            }
        }
        return formalized;

    }

}
