package com.example.geeksforgeeks.array;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentInAnArray {
    public int mostFreqEle(int[] arr) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the element with max frequency (tie-break by largest value)
        int maxFreq = 0;
        int result = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq || (count == maxFreq && num > result)) {
                maxFreq = count;
                result = num;
            }
        }

        return result;
    }

    static void main() {
        MostFrequentInAnArray sol = new MostFrequentInAnArray();

        // Example 1: [1, 2, 2, 2, 4, 1] → Output: 2
        int[] arr1 = {1, 2, 2, 2, 4, 1};
        System.out.println("Most frequent: " + sol.mostFreqEle(arr1)); // 2
    }
}
