package com.leetcode.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 387. First Unique Character in a String (Easy)
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * Runtime: 24 ms, faster than 57.12% of Java online submissions for First Unique Character in a String.
 * Memory: 49.2 MB, less than 52.10% of Java online submissions for First Unique Character in a String.
 */
public class EasyFirstUniqueChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Character> list = new LinkedList<Character>();
        for( int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if( map.containsKey(c) ) {
                if( list.contains(c) )
                    list.remove((Character) c);
            } else {
                map.put(c, i);
                list.add(c);
            }
        }

        if( list.isEmpty() )
            return -1;

        return map.get(list.get(0));

    }

}
