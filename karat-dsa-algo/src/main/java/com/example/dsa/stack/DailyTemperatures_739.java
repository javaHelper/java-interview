package com.example.dsa.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // While current temp is warmer than temp at top of stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // days waited
            }
            stack.push(i);
        }
        // Indices remaining in stack have no warmer day → answer already 0

        return answer;
    }

    static void main() {
        DailyTemperatures_739 x = new DailyTemperatures_739();

        // Example 1
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Input: " + Arrays.toString(temps1));
        System.out.println("Output: " + Arrays.toString(x.dailyTemperatures(temps1)));
        // Expected: [1, 1, 4, 2, 1, 1, 0, 0]

        // Example 2
        int[] temps2 = {30, 40, 50, 60};
        System.out.println("Input: " + Arrays.toString(temps2));
        System.out.println("Output: " + Arrays.toString(x.dailyTemperatures(temps2)));
        // Expected: [1, 1, 1, 0]

        // Example 3
        int[] temps3 = {30, 60, 90};
        System.out.println("Input: " + Arrays.toString(temps3));
        System.out.println("Output: " + Arrays.toString(x.dailyTemperatures(temps3)));
        // Expected: [1, 1, 0]
    }
}
