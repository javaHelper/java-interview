package com.example.geeksforgeeks.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class NextGreaterElement {

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int[] res = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : res) {
            ans.add(x);
        }
        return ans;
    }

    static void main() {
        NextGreaterElement x = new NextGreaterElement();
        System.out.println(x.nextLargerElement(new int[]{1, 3, 2, 4}));
    }
}
