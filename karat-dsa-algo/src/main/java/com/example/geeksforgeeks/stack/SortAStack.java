package com.example.geeksforgeeks.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortAStack {
    public void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        sortStack(st);
        insertSorted(st, top);
    }

    private void insertSorted(Stack<Integer> st, int element) {
        if (st.isEmpty() || st.peek() <= element) {
            st.push(element);
            return;
        }
        int top = st.pop();
        insertSorted(st, element);
        st.push(top);
    }

    // ========== HELPER: Print Stack (Top to Bottom) ==========
    public static void printStack(Stack<Integer> st) {
        // Create a copy to avoid modifying the original
        Stack<Integer> copy = new Stack<>();
        copy.addAll(st);
        List<Integer> list = new ArrayList<>();
        while (!copy.isEmpty()) {
            list.add(copy.pop());
        }
        System.out.println(list);
    }

    static void main() {
        SortAStack sol = new SortAStack();

        Stack<Integer> st1 = new Stack<>();
        st1.push(41);
        st1.push(3);
        st1.push(32);
        st1.push(2);
        st1.push(11);
        System.out.print("Input:  ");
        printStack(st1);
        sol.sortStack(st1);
        System.out.print("Output: ");
        printStack(st1);
        System.out.println();
    }
}
