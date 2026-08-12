package com.example.geeksforgeeks.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class StockSpanProblem {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>(); // Stores indices

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans.add(i + 1);
            } else {
                ans.add(i - stack.peek());
            }
            stack.push(i);
        }
        return ans;
    }

    static void main() {
        StockSpanProblem x = new StockSpanProblem();
        System.out.println(x.calculateSpan(new int[]{100, 80, 90, 120}));
    }
}
