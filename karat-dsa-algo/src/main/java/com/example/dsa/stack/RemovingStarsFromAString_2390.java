package com.example.dsa.stack;

import java.util.Stack;

public class RemovingStarsFromAString_2390 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
