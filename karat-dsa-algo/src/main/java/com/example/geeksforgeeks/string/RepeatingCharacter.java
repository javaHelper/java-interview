package com.example.geeksforgeeks.string;

public class RepeatingCharacter {
    static int repeatedCharacter(String S) {
        int[] freq = new int[26];
        for (char ch : S.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find leftmost character that repeats
        for (int i = 0; i < S.length(); i++) {
            if (freq[S.charAt(i) - 'a'] > 1) {
                return i;
            }
        }
        return -1;
    }

    static void main() {
        System.out.println(repeatedCharacter("geeksforgeeks"));
    }
}
