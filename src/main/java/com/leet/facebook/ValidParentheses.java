package com.leet.facebook;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * 1249. Minimum Remove to Make Valid Parentheses (Medium)
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
 * parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Runtime 38 ms Beats 41.93%
 * Memory 43.4 MB Beats 44.66%
 */
public class ValidParentheses {

    public String minRemoveToMakeValid(String s) {

        HashSet<Integer> skipSet = new HashSet<Integer>();
        Stack<Integer> stack = new Stack();
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if( c == '(' ) {
                stack.push(i);
            } else if( c == ')') {
                if( !stack.isEmpty() ) {
                    stack.pop();
                } else {
                    skipSet.add(i);
                }
            }
        }
        while( !stack.isEmpty() ) {
            int x = stack.pop();
            skipSet.add(x);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++) {
            if (!skipSet.contains(i))
                stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();

    }

}
