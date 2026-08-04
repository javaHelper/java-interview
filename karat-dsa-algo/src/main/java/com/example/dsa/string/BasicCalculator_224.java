package com.example.dsa.string;

import java.util.Stack;

public class BasicCalculator_224 {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1; // 1 for '+', -1 for '-'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
            // Ignore spaces
        }

        if (num != 0) {
            result += sign * num;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1: "1 + 1" → 2
        String s1 = "1 + 1";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + calculate(s1));
        System.out.println();

        // Example 2: " 2-1 + 2 " → 3
        String s2 = " 2-1 + 2 ";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + calculate(s2));
        System.out.println();

        // Example 3: "(1+(4+5+2)-3)+(6+8)" → 23
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + calculate(s3));
        System.out.println();

        // Example 4: "1-( -2)" → 3
        String s4 = "1-( -2)";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + calculate(s4));
        System.out.println();

        // Example 5: "2147483647" → 2147483647 (edge case: large number)
        String s5 = "2147483647";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + calculate(s5));
    }
}
