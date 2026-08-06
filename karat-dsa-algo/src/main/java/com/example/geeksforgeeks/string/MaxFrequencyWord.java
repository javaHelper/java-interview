package com.example.geeksforgeeks.string;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyWord {
    public String maximumFrequency(String s) {
        // base case:
        if (s.isEmpty()) {
            return "";
        }
        String[] words = s.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String ans = "";
        int maxFreq = 0;
        for (String word : words) {
            if (map.get(word) > maxFreq) {
                maxFreq = map.get(word);
                ans = word;
            }
        }
        return ans + " " + maxFreq;
    }

    static void main() {
        MaxFrequencyWord m = new MaxFrequencyWord();
        System.out.println(m.maximumFrequency("the devil in the sky"));
    }
}
