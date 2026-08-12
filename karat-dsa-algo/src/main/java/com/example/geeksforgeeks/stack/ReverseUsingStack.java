package com.example.geeksforgeeks.stack;

import java.util.Stack;

/**
 * Time: O(n) – We traverse the string once to push each character (O(n))
 *              and then pop each character once (O(n)). Total = O(2n) = O(n).
 *
 * Space: O(n) – The stack stores all n characters. The StringBuilder also stores n characters,
 *              but that is the output, so we usually count the stack as extra space.
 *              Auxiliary space = O(n).
 */
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
