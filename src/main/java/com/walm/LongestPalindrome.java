package com.walm;

import java.util.*;

/** 409. Longest Palindrome (Easy)
 * https://leetcode.com/problems/longest-palindrome/description/
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int longest = 0;
        HashSet<Character> set = new HashSet<Character>();

        for( char c: s.toCharArray() ) {
            if( set.contains(c) ) {
                longest = longest + 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if( set.isEmpty() )
            return longest;
        else
            return longest + 1;
    }

}
