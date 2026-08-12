package com.example.geeksforgeeks.stack;

import java.util.Stack;

public class ReverseAnArrayUsingStack {
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
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println("Original Stack : " + st);

        ReverseAnArrayUsingStack.reverseStack(st);
        System.out.println("Reversed Stack : " + st);
    }
}
