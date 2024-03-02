package com.uber;

/**
 * 14. Longest Common Prefix (Easy)
 * https://leetcode.com/problems/longest-common-prefix/description/
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null && strs.length == 0)
            return "";

        int x = 0;
        while (x < strs[0].length()) {
            if (checkAll(strs, x)) {
                x++;
                continue;
            } else
                break;
        }
        return strs[0].substring(0, x);

    }

    private boolean checkAll(String[] strs, int x) {

        char c = strs[0].charAt(x);
        boolean result = true;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() > x && c == strs[i].charAt(x))
                continue;

            result = false;
            break;
        }

        return result;

    }

}
