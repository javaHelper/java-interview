package com.example.geeksforgeeks.stack;

import java.util.Stack;

public class ParenthesisChecker {

    public boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top != '(' && c == ')') ||
                        (top != '{' && c == '}') ||
                        (top != '[' && c == ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static void main() {
        ParenthesisChecker x = new ParenthesisChecker();
        System.out.println(x.isBalanced("[{()}]"));
        System.out.println(x.isBalanced("[()()]{}"));
    }
}
