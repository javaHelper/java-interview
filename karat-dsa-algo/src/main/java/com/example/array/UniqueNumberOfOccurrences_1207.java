package com.example.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Check uniqueness of frequencies
        Set<Integer> seen = new HashSet<>();
        for (int count : freq.values()) {
            if (seen.contains(count)) {
                return false;
            }
            seen.add(count);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences_1207 x = new UniqueNumberOfOccurrences_1207();
        System.out.println(x.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(x.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(x.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
