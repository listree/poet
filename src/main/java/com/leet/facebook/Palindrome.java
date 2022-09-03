package com.leet.facebook;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * 125. Valid Palindrome (Easy)
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * Runtime 911 ms Beats 13.33%
 */
public class Palindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // compare the string with its reverse
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
