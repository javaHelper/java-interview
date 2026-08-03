package com.example.stack;

import java.util.Stack;

/**
 We maintain two separate stacks:
-  stack – the primary stack that holds all pushed values, preserving the standard LIFO order.
-  minStack – an auxiliary stack that keeps track of the current minimum value at any point in time.

 The goal is that after each operation, minStack.peek() always returns the minimum value present in stack. This allows getMin() to work in O(1) time.
 *
 *2. push(int val)
 * We push the new value val onto the main stack.
 * For the minStack: we push val onto minStack only if it is the new minimum.
 * If minStack is empty, val is obviously the minimum → push it.
 * Else, compare val with the current minimum (minStack.peek()).
 *      If val is less than or equal to the current minimum, push val onto minStack.
 *      Otherwise, do nothing on minStack.
 *
 * Why "less than or equal to"?
 * If we have duplicate minimum values, we must store them on minStack so that when one is popped,
 * the next minimum remains available.
 * Example: push 1, push 1 → both 1s should be in minStack so that after popping one, the minimum is still 1.
 *
 *3. pop()
 * We remove the top element from the main stack.
 * Before popping, we check if the value being removed is the current minimum (i.e., the top of minStack).
 *
 * - If stack.peek().equals(minStack.peek()), then this value is the current minimum, so we must pop it
 * from minStack as well.
 * - Otherwise, we leave minStack unchanged.
 *
 * After handling minStack, we finally pop the main stack.
 */
public class MinStack_155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        // Push to minStack only if it's empty or val is <= current minimum
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        // If the popped value is the current minimum, pop from minStack too
        if (stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    static void main() {
        // Example: ["MinStack","push","push","push","getMin","pop","top","getMin"]
        // [[],[-2],[0],[-3],[],[],[],[]]
        // Expected: [null,null,null,null,-3,null,0,-2]

        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin(): " + minStack.getMin()); // Returns -3

        minStack.pop();
        System.out.println("top(): " + minStack.top());       // Returns 0
        System.out.println("getMin(): " + minStack.getMin()); // Returns -2


        MinStack_155 ms2 = new MinStack_155();
        ms2.push(5);
        ms2.push(2);
        ms2.push(3);
        ms2.push(1);
        System.out.println("getMin(): " + ms2.getMin()); // Returns 1
        ms2.pop();
        System.out.println("getMin(): " + ms2.getMin()); // Returns 2
        ms2.pop();
        System.out.println("getMin(): " + ms2.getMin()); // Returns 2
        ms2.pop();
        System.out.println("getMin(): " + ms2.getMin()); // Returns 5
    }
}
