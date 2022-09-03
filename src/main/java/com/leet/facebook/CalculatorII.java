package com.leet.facebook;


import com.leet.LeetUtils;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * 227. Basic Calculator II (Medium)
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * Runtime 177 ms Beats 5.5%
 * Memory 54.9 MB Beats 9.8%
 */
public class CalculatorII {
    static CalculatorII tester = new CalculatorII();

    public final static void main(String[] arg) {
        String s = "3+2*2"; // 7
        LeetUtils.printResult(tester.calculate(s));

        String s1 = " 3/2 "; // 1
        LeetUtils.printResult(tester.calculate(s1));

        String s3 = "1+2*5/3+6/4*2";
        LeetUtils.printResult(tester.calculate(s3)); // be 6 !!!
    }

    public int calculate(String s) {
        String[] tokens = s.replaceAll(" ","").split("(?=[\\+;\\-])");
        int result = multiplyOrDivide(tokens[0]);
        for(int i = 1; i < tokens.length; i++) {
            result += multiplyOrDivide(tokens[i]);
        }
        return result;
    }

    public int multiplyOrDivide(String s) {
        String[] tokens = s.split("(?=[\\*;\\/])");
        int result = toInteger(tokens[0]);
        for(int i = 1; i < tokens.length; i++) {
            if( tokens[i].startsWith("*") )
                result *= toInteger(tokens[i].substring(1));
            else
                result /= toInteger(tokens[i].substring(1));
        }
        return result;
    }

    public int toInteger(String s) {
        return Integer.parseInt(s.trim());
    }

}
