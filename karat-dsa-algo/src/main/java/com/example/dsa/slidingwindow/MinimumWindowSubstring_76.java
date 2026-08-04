package com.example.dsa.slidingwindow;

public class MinimumWindowSubstring_76 {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) {
                return "";
            }

            // 1. Create an array to store the required frequency of characters from t.
            int[] required = new int[128];
            for (char c : t.toCharArray()) {
                required[c]++;
            }

            int left = 0, right = 0;
            int formed = 0; // Tracks how many distinct characters in t have been fully matched.
            int requiredCount = 0; // Total distinct characters in t.

            // Count how many distinct characters are in t.
            for (int count : required) {
                if (count > 0) requiredCount++;
            }

            int minLen = Integer.MAX_VALUE;
            int minLeft = 0;
            int[] windowCounts = new int[128];

            // 2. Expand the window to the right.
            while (right < s.length()) {
                char c = s.charAt(right);
                windowCounts[c]++;

                // If the current character is needed and its count matches the required count.
                if (required[c] > 0 && windowCounts[c] == required[c]) {
                    formed++;
                }

                // 3. Once the window is valid, try to shrink it from the left.
                while (left <= right && formed == requiredCount) {
                    c = s.charAt(left);

                    // Update the best result if this window is smaller.
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }

                    // Remove the leftmost character from the window.
                    windowCounts[c]--;
                    if (required[c] > 0 && windowCounts[c] < required[c]) {
                        formed--;
                    }

                    left++; // Shrink the window from the left.
                }
                right++; // Continue expanding the window.
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
        }


    static void main() {
        MinimumWindowSubstring_76 sol = new MinimumWindowSubstring_76();
        System.out.println(sol.minWindow("ADOBECODEBANC","ABC"));
    }
}
