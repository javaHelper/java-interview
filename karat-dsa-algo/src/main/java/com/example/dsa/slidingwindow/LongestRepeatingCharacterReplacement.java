package com.example.dsa.slidingwindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // Frequency of characters in the current window
        int left = 0;
        int maxFreq = 0;            // Highest frequency of any single character in the window
        int maxLength = 0;          // Longest valid window found

        for (int right = 0; right < s.length(); right++) {
            // Add the new character to the window
            char current = s.charAt(right);
            count[current - 'A']++;

            // Update the maximum frequency in the current window
            maxFreq = Math.max(maxFreq, count[current - 'A']);

            // Window size = right - left + 1
            // Replacements needed = window size - maxFreq
            // If replacements needed > k, shrink the window from the left
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
                // Note: maxFreq is NOT recalculated here.
                // Keeping a higher maxFreq only makes the condition stricter,
                // which is safe and saves O(26) scanning time.
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    static void main() {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement("XYYX", 2));
        System.out.println(l.characterReplacement("AAABABB", 1));
    }
}
