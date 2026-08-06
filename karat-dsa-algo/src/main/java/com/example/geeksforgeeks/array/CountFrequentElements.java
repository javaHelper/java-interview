package com.example.geeksforgeeks.array;

import java.util.HashMap;
import java.util.Map;

public class CountFrequentElements {
    public int countOccurence(int[] arr, int k) {
        int n = arr.length;
        int threshold = n / k;

        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Count elements with frequency > threshold
        int result = 0;
        for (int count : freqMap.values()) {
            if (count > threshold) {
                result++;
            }
        }
        return result;
    }

    static void main() {
        CountFrequentElements x = new CountFrequentElements();
        System.out.println(x.countOccurence(new int[]{3, 1, 2, 2, 1, 2, 3, 3}, 4));
        System.out.println(x.countOccurence(new int[]{2, 3, 3, 2}, 2));
    }
}
