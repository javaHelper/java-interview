package com.example.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {
    static class MyStack {
        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        // Push element x onto stack.
        // O(n) time - rotate the queue so new element becomes front.
        public void push(int x) {
            queue.add(x);
            int size = queue.size();
            // Move all previous elements behind the new one
            while (size > 1) {
                queue.add(queue.remove());
                size--;
            }
        }

        // Removes and returns the top element.
        // O(1) time - front is the stack top.
        public int pop() {
            return queue.remove();
        }

        // Returns the top element without removing it.
        // O(1) time.
        public int top() {
            return queue.peek();
        }

        // Returns whether the stack is empty.
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    static void main() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());   // should print 3
        System.out.println("Pop: " + stack.pop());           // should print 3
        System.out.println("Top after pop: " + stack.top()); // should print 2
        System.out.println("Is empty? " + stack.empty());    // false

        stack.pop(); // removes 2
        stack.pop(); // removes 1

        System.out.println("Is empty after all pops? " + stack.empty()); // true
    }
}
