package com.example.geeksforgeeks.stack;

import java.util.Stack;

public class DeleteMidOfAStack {
    public void deleteMid(Stack<Integer> s) {
        int mid = s.size() / 2;
        delete(s, mid);
    }

    private void delete(Stack<Integer> s, int mid) {
        if (mid == 0) {
            s.pop();
            return;
        }
        int top = s.pop();
        delete(s, mid - 1);
        s.push(top);
    }

    static void main() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Before : " + stack);

        DeleteMidOfAStack sol = new DeleteMidOfAStack();
        sol.deleteMid(stack);

        System.out.println("After  : " + stack);
    }
}
