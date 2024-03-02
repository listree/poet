package com.bloom;

import java.util.*;

/**
 * 301. Remove Invalid Parentheses Solved Hard
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 * Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
 * Runtime Beats 68.64% & Memory Beats 35.51%
 */
public class InvalidParentheses {


    public final static void main(String[] args) {

        InvalidParentheses invalidParentheses = new InvalidParentheses();
        System.out.println(invalidParentheses.removeInvalidParentheses("()())()"));
        System.out.println(invalidParentheses.removeInvalidParentheses("(a)())()"));
        System.out.println(invalidParentheses.removeInvalidParentheses(""));
        System.out.println(invalidParentheses.removeInvalidParentheses("n"));
        System.out.println(invalidParentheses.removeInvalidParentheses(")("));

    }

    public List<String> removeInvalidParentheses(String s) {

        List<String> validResult = new ArrayList<>();
        HashSet<String> levelSet = new HashSet<String>();

        if( checkValid(s) ) {
            validResult.add(s);
            return validResult;
        } else {
            levelSet.add(s);
        }

        HashSet<String> nextSet = new HashSet<String>();
        boolean found = false;

        while( !levelSet.isEmpty() ) {
            nextSet = new HashSet<>();
            for (String str : levelSet) {
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (c == ')' || c == '(') {
                        String newString = str.substring(0, i) + str.substring(i + 1);
                        if (!nextSet.contains(newString)) {
                            //System.out.println("add:" + newString + "check:" + checkValid(newString));
                            nextSet.add(newString);
                            if (checkValid(newString)) {
                                found = true;
                                validResult.add(newString);
                            }
                        }
                    }
                }
            } // end of iterate on Level Set
            if (found)
                return validResult;
            else
                levelSet = nextSet;
        }

        return validResult;
    }

    private boolean checkValid(String str) {

        int count = 0 ;
        for( char ch: str.toCharArray() ) {
            if( ch == '(' ) {
                count++;
            } else if( ch == ')' ) {
                count--;
            } else {
                //other character, ignore it!!!
            }

            if( count < 0 ) {
                return false;
            }

        }
        return count == 0;
    }


}
