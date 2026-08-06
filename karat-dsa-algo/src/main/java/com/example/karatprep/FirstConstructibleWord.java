package com.example.karatprep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstConstructibleWord {
    public String firstConstructibleWord(String s, List<String> words) {
        // Build a frequency map of characters available in s
        Map<Character, Integer> available = new HashMap<>();
        for (char c : s.toCharArray()) {
            available.put(c, available.getOrDefault(c, 0) + 1);
        }

        // Check each word in order
        for (String word : words) {
            if (canConstruct(word, new HashMap<>(available))) {
                return word;
            }
        }
        return null; // No word can be constructed
    }

    /**
     * Checks if a single word can be constructed from the given character counts.
     */
    private boolean canConstruct(String word, Map<Character, Integer> available) {
        for (char c : word.toCharArray()) {
            int count = available.getOrDefault(c, 0);
            if (count == 0) {
                return false; // Not enough of this character
            }
            available.put(c, count - 1);
        }
        return true;
    }

    static void main() {
        FirstConstructibleWord sol = new FirstConstructibleWord();

        String s = "balloons";
        List<String> words = Arrays.asList("son", "ball", "friends");
        System.out.println(sol.firstConstructibleWord(s, words)); // Output: son
    }
}
