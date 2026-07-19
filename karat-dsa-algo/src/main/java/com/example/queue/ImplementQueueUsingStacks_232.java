package com.example.queue;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {
     static class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        // Push element x to the back of queue.
        public void push(int x) {
            inStack.push(x);
        }

        // Removes and returns the front element.
        public int pop() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.pop();
        }

        // Returns the front element without removing it.
        public int peek() {
            if (outStack.isEmpty()) {
                transfer();
            }
            return outStack.peek();
        }

        // Returns true if queue is empty.
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        // Move all elements from inStack to outStack.
        private void transfer() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        // ----- Test main -----
        public static void main(String[] args) {
            MyQueue queue = new MyQueue();

            queue.push(1);
            queue.push(2);
            System.out.println("peek: " + queue.peek());   // 1
            System.out.println("pop: " + queue.pop());     // 1
            System.out.println("empty: " + queue.empty()); // false

            queue.push(3);
            System.out.println("peek: " + queue.peek());   // 2
            System.out.println("pop: " + queue.pop());     // 2
            System.out.println("pop: " + queue.pop());     // 3
            System.out.println("empty: " + queue.empty()); // true
        }
    }
}