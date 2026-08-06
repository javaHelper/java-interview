package com.example.geeksforgeeks.string;

public class MostFrequentCharacter {
    public char getMaxOccuringChar(String s) {
        // Frequency array for 26 lowercase letters
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Find the character with maximum frequency
        // Traversing from 0 to 25 ensures lexicographically smallest tie-break
        int maxCount = 0;
        char result = 'a';

        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                result = (char) ('a' + i);
            }
        }

        return result;
    }

    static void main() {
        MostFrequentCharacter sol = new MostFrequentCharacter();

        // Test cases
        System.out.println(sol.getMaxOccuringChar("testsample"));   // e
        System.out.println(sol.getMaxOccuringChar("geeksforgeeks")); // e
        System.out.println(sol.getMaxOccuringChar("test"));         // t
        System.out.println(sol.getMaxOccuringChar("aabbcc"));       // a
        System.out.println(sol.getMaxOccuringChar("abcde"));        // a
        System.out.println(sol.getMaxOccuringChar("zzzz"));         // z
        System.out.println(sol.getMaxOccuringChar("aabbbcc"));      // b
    }
}
