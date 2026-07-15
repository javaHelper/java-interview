package com.example.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses_20 {
    static void main() {
        ValidParentheses_20 x = new ValidParentheses_20();
        System.out.println(x.isValid("()"));
        System.out.println(x.isValid("()[]{}"));
        System.out.println(x.isValid("(]"));
        System.out.println(x.isValid("([])"));
        System.out.println(x.isValid("([)]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                Character top = stack.pop();
                if ((ch == '(' && top == ')') || (ch == '[' && top == ']') || (ch == '{' && top == '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != ch) {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}
