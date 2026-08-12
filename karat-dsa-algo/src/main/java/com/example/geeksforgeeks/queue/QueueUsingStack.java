package com.example.geeksforgeeks.queue;

import java.util.Stack;

public class QueueUsingStack {
    static class myQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Enqueue
        void enqueue(int x) {
            s1.push(x);
        }

        // Dequeue
        void dequeue() {
            if (s1.isEmpty() && s2.isEmpty())
                return;

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            s2.pop();
        }

        // Front element
        int front() {
            if (s1.isEmpty() && s2.isEmpty())
                return -1;

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        // Queue size
        int size() {
            return s1.size() + s2.size();
        }
    }

    static void main() {
        QueueUsingStack.myQueue q = new QueueUsingStack.myQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.front()); // 10
        System.out.println(q.size());  // 3

        q.dequeue();

        System.out.println(q.front()); // 20
        System.out.println(q.size());  // 2

        q.enqueue(40);

        System.out.println(q.front()); // 20
        System.out.println(q.size());  // 3

        q.dequeue();

        System.out.println(q.front()); // 30
        System.out.println(q.size());  // 2
    }
}
