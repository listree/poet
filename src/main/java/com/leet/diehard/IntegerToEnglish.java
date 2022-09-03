package com.leet.diehard;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 * Convert a non-negative integer num to its English words representation.
 * 273. Integer to English Words (Hard)
 * Input: num = 123 Output: "One Hundred Twenty Three"
 * Input: num = 12345 Output: "Twelve Thousand Three Hundred Forty Five"
 * Input: num = 1234567 Output: "One Million (Two Hundred Thirty Four) Thousand (Five Hundred Sixty Seven)"
 * Runtime: 25 ms, faster than 10.67% of Java online submissions for Integer to English Words.
 * Memory: 43.9 MB, less than 6.88% of Java online submissions for Integer to English Words.
 */
public class IntegerToEnglish {

    private final String[] LessThan20 = {"",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] Tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] Thousands = {"", "Thousand", "Million", "Billion", "Trillion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) + Thousands[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return LessThan20[num];
        else if (num < 20)
            return LessThan20[num] + " ";
        else if (num < 100)
            return Tens[num / 10] + " " + helper(num % 10);
        else
            return LessThan20[num / 100] + " Hundred " + helper(num % 100);
    }


}
