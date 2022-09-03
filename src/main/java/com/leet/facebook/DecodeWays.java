package com.leet.facebook;

import java.util.*;

/**
 * https://leetcode.com/problems/decode-ways/
 * 91. Decode Ways (Medium)
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the
 * mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * Given a string s containing only digits, return the number of ways to decode it.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * if not use DP, Time Limit Exceeded on "111111111111111111111111111111111111111111111"
 * Runtime 2 ms Beats 56.82%
 * Memory 42.5 MB Beats 38.34%
 */
public class DecodeWays {

    public final static void main(String[] args) {
        DecodeWays leet = new DecodeWays();
        System.out.println(leet.numDecodings("12")); // 2
        System.out.println(leet.numDecodings("226")); // 3 e.g. "2 2 6" + "22 6" + "2 26"
        System.out.println(leet.numDecodings("06")); // 0
        System.out.println(leet.numDecodings("111111111111111111111111111111111111111111111")); // 0
    }

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public int numDecodings(String s) {

        if( map.containsKey(s) )
            return map.get(s);

        if( s.isEmpty() )
            return 1;

        if( s.startsWith("0"))
            return 0;

        if (s.length() == 1)
            return 1;

        String s1 = s.substring(1);
        int n1 = numDecodings(s1); // "2"
        map.put(s1, n1);

        int n2 = 0;
        if( s.length() > 1 && Integer.parseInt(s.substring(0,2)) < 27 ) {
            String s2 = s.substring(2);
            n2 = numDecodings(s2); // ""
            map.put(s2, n2);
        }

        return n1 + n2;

    }

}
