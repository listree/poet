package com.leet.facebook;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 13. Roman to Integer (Easy)
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9. => IV(4), IX(9)
 * X can be placed before L (50) and C (100) to make 40 and 90. => XL(40). XC(90)
 * C can be placed before D (500) and M (1000) to make 400 and 900. -> CD(400), CM(900)
 * Given a roman numeral, convert it to an integer.
 * Runtime 3 ms Beats 100%
 * Memory 42.4 MB Beats 87%
 */
public class ConvertRoman {

    public final static void main(String[] args) {
        ConvertRoman leet = new ConvertRoman();
        System.out.println(leet.romanToInt("IV"));
    }

    public int romanToInt(String s) {
        int x = 0;
        int i = s.length() - 1;
        while( i > -1 ) {
            char c = s.charAt(i);
            if( c == 'I' ) {
                x += 1;
                i--;
                continue;
            }

            if( c == 'V' || c == 'X' ) {
                if( i > 0 && s.charAt(i-1) == 'I' ) {
                    x += (c == 'V') ? 4: 9;
                    i--; i--;
                } else {
                    x += (c == 'V') ? 5: 10;
                    i--;
                }
                continue;
            }

            if( c == 'X' ) {
                x += 10;
                i--;
                continue;
            }

            if( c == 'L' || c == 'C' ) {
                if( i > 0 && s.charAt(i-1) == 'X' ) {
                    x += (c == 'L') ? 40: 90;
                    i--; i--;
                } else {
                    x += (c == 'L') ? 50: 100;
                    i--;
                }
                continue;
            }

            if( c == 'C' ) {
                x += 100;
                i--;
                continue;
            }

            if( c == 'D' || c == 'M' ) {
                if( i > 0 && s.charAt(i-1) == 'C' ) {
                    x += (c == 'D') ? 400: 900;
                    i--; i--;
                } else {
                    x += (c == 'D') ? 500: 1000;
                    i--;
                }
                continue;
            }

        }
        return x;
    }

}
