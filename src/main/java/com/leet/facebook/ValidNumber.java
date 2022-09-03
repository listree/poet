package com.leet.facebook;

import com.leet.LeetUtils;

/**
 * https://leetcode.com/problems/valid-number/
 * 65. Valid Number (Hard)
 * A valid number can be split up into these components (in order):
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * One or more digits, followed by a dot '.'.
 * One or more digits, followed by a dot '.', followed by one or more digits.
 * A dot '.', followed by one or more digits.
 * An integer can be split up into these components (in order):
 * (Optional) A sign character (either '+' or '-').
 * One or more digits.
 * For example, all the following are valid numbers:
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
 * while the following are not valid numbers:
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 *
 * Given a string s, return true if s is a valid number.
 */
public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber leet = new ValidNumber();
        String[] validNumbers = {"2", "0089", "-0.1", "+3.14", "4.", "-.9",
                "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};

        for(String str: validNumbers) {
            LeetUtils.printSpace(leet.isNumber(str));
        }

        System.out.println("=====");

        String[] invalidNumbers = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53","Infinity", "959440.94f","."};
        for(String str: invalidNumbers) {
            LeetUtils.printSpace(leet.isNumber(str));
        }

    }

    public boolean isNumber(String s) {
        int eEIndex = s.indexOf('e');
        if (eEIndex == -1)
            eEIndex = s.indexOf('E');
        if (eEIndex != -1) {
            String s2 = s.substring(eEIndex + 1);
            if (!isInteger(s2))
                return false;
            String s1 = s.substring(0, eEIndex);
            return isFloat(s1);
        } else {
            return isFloat(s);
        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isPositiveInteger(String s) {
        try {
            int x = Integer.parseInt(s);
            return x > 0 ;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isFloat(String s) {
        int dot = s.indexOf('.');
        if( dot != -1 ) {
            String s1 = s.substring(0,dot);
            String s2 = s.substring(dot+1);
            if(s1.isEmpty() && s2.isEmpty() )
                return false;
            boolean x = s1.isEmpty() || s1.equals("-") || s1.equals("+") || isInteger(s1);
            boolean y = s2.isEmpty() || isPositiveInteger(s2);
            return x && y;
        } else {
            return isInteger(s);
        }
    }

}
