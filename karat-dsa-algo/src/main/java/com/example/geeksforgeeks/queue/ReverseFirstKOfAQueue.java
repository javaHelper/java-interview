package com.example.geeksforgeeks.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseFirstKOfAQueue {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) {
            return q;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        // Reverse first k elements
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        // Move remaining elements to the back
        int remaining = q.size() - k;
        while (remaining-- > 0) {
            q.offer(q.poll());
        }
        return q;
    }

    static void main() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        int k = 3;
        ReverseFirstKOfAQueue sol = new ReverseFirstKOfAQueue();
        Queue<Integer> ans = sol.reverseFirstK(q, k);
        System.out.println(ans);
    }
}
