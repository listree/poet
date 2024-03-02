package com.meta;

/**
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 * 2109. Adding Spaces to a String Medium Accepted
 * You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original
 * string where spaces will be added. Each space should be inserted before the character at the given index.
 * For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C',
 * which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
 * Return the modified string after the spaces have been added.
 */
public class AddSpaces {

    public String addSpaces(String s, int[] spaces) {

        if( spaces == null || spaces.length == 0)
            return s;

        StringBuffer buf = new StringBuffer();
        if( spaces[0] != 0) {
            buf.append(s.substring(0, spaces[0]));
        }

        for( int i = 1; i < spaces.length; i++)
            buf.append(" ").append(s.substring(spaces[i-1], spaces[i]));

        buf.append(" ").append(s.substring(spaces[spaces.length -1]));

        return buf.toString();

    }
}
