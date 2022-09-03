package com.leet.google;

import java.util.*;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 150. Evaluate Reverse Polish Notation (Medium)
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * Note that division between two integers should truncate toward zero.
 * It is guaranteed that the given RPN expression is always valid. That means the expression
 * would always evaluate to a result, and there will not be any division by zero operation.
 * Runtime: 22 ms, faster than 12.83% of Java online submissions for Evaluate Reverse Polish Notation.
 * Memory Usage: 43.7 MB, less than 70.62% of Java online submissions for Evaluate Reverse Polish Notation.
 */
public class PolishNotation {

    public static void main(String[] args) {
        PolishNotation leeter = new PolishNotation();
        // Example 1: ((2 + 1) * 3) = 9
        String[] tokens = {"2","1","+","3","*"};
        System.out.println( leeter.evalRPN(tokens) );

        // Example 2: (4 + (13 / 5)) = 6
        String[] tokens2 = {"4","13","5","/","+"};
        System.out.println( leeter.evalRPN(tokens2) );

        // Example 3: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println( leeter.evalRPN(tokens3) );

    }

    Integer parseOrNull(String s) {
        try {
            return Integer.parseInt(s);
        } catch( Exception ex) {
            return null;
        }
    }

    Integer op(int x1, int x2, String op) {
        switch(op) {
            case "+":
                return x1 + x2;
            case "-":
                return x1 - x2;
            case "*":
                return x1 * x2;
            case "/":
                return x1 / x2;
            default:
                return 0;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for( String token: tokens ) {

            Integer x = parseOrNull(token);
            if( x != null) {
                stack.push(x);
            } else {
                Integer x2 = stack.pop();
                Integer x1 = stack.pop();
                Integer result = op(x1, x2, token);
                stack.push(result);
            }
        }

        return stack.pop();

    }

}
