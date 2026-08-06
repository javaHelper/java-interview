package com.example.geeksforgeeks.string;

import java.util.Stack;

public class ReverseUsingStack {
    public String reverse(String s) {
        Stack<Character> stack = new Stack<>();

        // Push all the chars
        for(char c : s.toCharArray()){
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        // pop all the chars
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    static void main() {
        ReverseUsingStack r = new ReverseUsingStack();
        System.out.println(r.reverse("GeeksforGeeks"));
    }
}
