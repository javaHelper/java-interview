package com.example.dsa.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    static void main(String[] args) {
        EvaluateReversePolishNotation_150 x = new EvaluateReversePolishNotation_150();

        // Example 1: ["2","1","+","3","*"] → 9
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + x.evalRPN(tokens1)); // Output: 9

        // Example 2: ["4","13","5","/","+"] → 6
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result: " + x.evalRPN(tokens2)); // Output: 6

        // Example 3: Complex expression → 22
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Result: " + x.evalRPN(tokens3)); // Output: 22
    }
}
