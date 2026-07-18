package com.example.tree.treefundamentals;

import java.util.Stack;

public class ValidParenthesis_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis_20 parenthesis = new ValidParenthesis_20();

        // Test cases
        System.out.println(parenthesis.isValid("()")); // true
        System.out.println(parenthesis.isValid("()[]{}")); // true
        System.out.println(parenthesis.isValid("(]")); // false
        System.out.println(parenthesis.isValid("([)]")); // false
        System.out.println(parenthesis.isValid("{[]}")); // true
    }
}
