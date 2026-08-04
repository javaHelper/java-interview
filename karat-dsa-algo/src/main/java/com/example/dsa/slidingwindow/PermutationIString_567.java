package com.example.dsa.slidingwindow;

public class PermutationIString_567 {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // If s1 is longer than s2, it's impossible to find a permutation
        if (n > m) {
            return false;
        }

        // Frequency arrays for 26 lowercase English letters
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count frequencies in s1
        for (int i = 0; i < n; i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        // Initialize the first window in s2
        for (int i = 0; i < n; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Check the first window
        if (matches(count1, count2)) {
            return true;
        }

        // Slide the window across s2
        for (int i = n; i < m; i++) {
            // Remove the leftmost character of the previous window
            count2[s2.charAt(i - n) - 'a']--;
            // Add the new character on the right
            count2[s2.charAt(i) - 'a']++;

            // Check if the current window is a permutation of s1
            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
