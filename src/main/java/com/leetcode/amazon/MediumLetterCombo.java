package com.leetcode.amazon;

import java.util.*;


/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 17. Letter Combinations of a Phone Number (Medium)
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. Return the answer in any order. A mapping of digits to letters (just like on the telephone buttons) is
 * given below. Note that 1 does not map to any letters.
 * Runtime: 3 ms, faster than 51.00% of Java online submissions for Letter Combinations of a Phone Number.
 * Memory: 42.6 MB, less than 69.76% of Java online submissions for Letter Combinations of a Phone Number.
 */
public class MediumLetterCombo {

    public List<String> letterCombinations(String digits) {
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        map.put('2',new HashSet<Character>(Arrays.asList('a', 'b', 'c')));
        map.put('3',new HashSet<Character>(Arrays.asList('d', 'e', 'f')));
        map.put('4',new HashSet<Character>(Arrays.asList('g', 'h', 'i')));
        map.put('5',new HashSet<Character>(Arrays.asList('j', 'k', 'l')));
        map.put('6',new HashSet<Character>(Arrays.asList('m', 'n', 'o')));
        map.put('7',new HashSet<Character>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8',new HashSet<Character>(Arrays.asList('t', 'u', 'v')));
        map.put('9',new HashSet<Character>(Arrays.asList('w', 'x', 'y', 'z')));
        return letterCombinations(digits, map);

    }

    List<String> letterCombinations(String digits, HashMap<Character, Set<Character>> map) {
        List<String> list = new ArrayList<String>();

        if( digits.length() < 1)
            return list;

        Character c = digits.charAt(0);
        Set<Character> set = map.get(c);
        if( digits.length() == 1) {
            for( Character x : set) {
                list.add("" + x);
            }
            return list;
        }

        List<String> sublist = letterCombinations(digits.substring(1), map);
        for( Character x : set) {
            for( String y : sublist) {
                list.add( x + y);
            }
        }
        return list;
    }

}

