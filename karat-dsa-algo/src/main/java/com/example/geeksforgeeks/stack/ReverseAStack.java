package com.example.geeksforgeeks.stack;

import java.util.Stack;

public class ReverseAStack {
    public static void reverseStack(Stack<Integer> st) {
        // Base case: if stack is empty, return[reference:16]
        if (st.isEmpty()) {
            return;
        }

        // Hold the top element and remove it[reference:17]
        int top = st.pop();

        // Recursively reverse the remaining stack[reference:18]
        reverseStack(st);

        // Insert the held element at the bottom[reference:19]
        insertAtBottom(st, top);
    }

    private static void insertAtBottom(Stack<Integer> st, int x) {
        // Base case: if stack is empty, push the element[reference:12]
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        // Hold the top element and remove it[reference:13]
        int top = st.pop();

        // Recursively call to reach the bottom[reference:14]
        insertAtBottom(st, x);

        // Put the held element back on top[reference:15]
        st.push(top);
    }

    static void main() {
        // Example 1: [3, 2, 1, 7, 6] → [6, 7, 1, 2, 3]
        Stack<Integer> st1 = new Stack<>();
        st1.push(3);
        st1.push(2);
        st1.push(1);
        st1.push(7);
        st1.push(6);
        System.out.println("Original stack (top to bottom): " + st1);
        reverseStack(st1);
        System.out.println("Reversed stack (top to bottom): " + st1);
        System.out.println();
    }
}
