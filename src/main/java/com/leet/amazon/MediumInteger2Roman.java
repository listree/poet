package com.leet.amazon;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *   12. Integer to Roman (Medium)
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together.
 * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * Runtime: 13 ms, faster than 40.54% of Java online submissions for Integer to Roman.
 * Memory: 46 MB, less than 41.51% of Java online submissions for Integer to Roman.
 */
public class MediumInteger2Roman {

    public String intToRoman(int num) {

        String string = convert(num % 10, "I", "V", "X");

        num = num / 10;
        if (num > 0)
            string = convert(num % 10, "X", "L", "C") + string;

        num = num / 10;
        if (num > 0)
            string = convert(num % 10, "C", "D", "M") + string;

        num = num / 10;
        if (num > 0)
            string = repeat("M", num % 10) + string;

        return string;

    }

    String convert(int x, String x1, String x2, String x3) {
        if (x <= 3)
            return repeat(x1, x);
        if (x == 4)
            return x1 + x2;
        if (x == 5)
            return x2;
        if (x < 9)
            return x2 + repeat(x1, x - 5);
        if (x == 9)
            return x1 + x3;

        return "";
    }

    String repeat(String x, int n) {
        String string = "";
        while (n-- > 0) {
            string += x;
        }
        return string;
    }

}
