package com.leet.google;

import java.util.*;

/**
 * https://leetcode.com/problems/expression-add-operators/
 * 282. Expression Add Operators (Hard)
 * Given a string num that contains only digits and an integer target, return all possibilities to insert the binary
 * operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
 * Note that operands in the returned expressions should not contain leading zeros.
 * Example 1:
 * Input: num = "123", target = 6
 * Output: ["1*2*3","1+2+3"]
 * Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
 *
 * Example 2:
 * Input: num = "232", target = 8
 * Output: ["2*3+2","2+3*2"]
 * Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
 *
 * Example 3:
 * Input: num = "3456237490", target = 9191
 * Output: []
 * Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 */
public class Expression {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList();
        calculate(num, target, "", result);
        return result;
    }

    private void calculate(String num, int target, String prefix, List<String> result) {
        if( num.length() == 0)
            return;

        if( num.length() == 1) {
            int x = num.charAt(0) - '0';
            if (x == target) {
                result.add( prefix + num.charAt(0) );
            }
        }

        if( num.length() >= 2) {
            int x = num.charAt(0) - '0';
            int y = num.charAt(1) - '0';

            if( x * y == target ) {
                result.add(prefix + x + "*" + y);
            } else if( x / y == target ) {
                result.add(prefix + x + "/" + y);
            } else {
                calculate(num.substring(1), target - x, prefix + "+" + x, result);
                calculate(num.substring(1), target + x, prefix + "-" + x, result);
            }
        }

    }

}
