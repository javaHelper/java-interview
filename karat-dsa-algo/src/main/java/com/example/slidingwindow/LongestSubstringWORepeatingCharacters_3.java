package com.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWORepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character already exists and its last occurrence is inside the window
            if (lastIndex.containsKey(ch) && lastIndex.get(ch) >= left) {
                // Move left pointer past the previous occurrence
                left = lastIndex.get(ch) + 1;
            }

            // Update the last occurrence of the character
            lastIndex.put(ch, right);

            // Update the maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
