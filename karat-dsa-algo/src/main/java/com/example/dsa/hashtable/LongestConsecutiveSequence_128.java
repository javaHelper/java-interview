package com.example.dsa.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        // Edge case: empty array → no sequence[reference:25]
        if (nums.length == 0) {
            return 0;
        }

        // Step 1: Insert all numbers into a HashSet for O(1) lookups[reference:26]
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Iterate through each unique number[reference:27]
        for (int num : set) {
            // Step 3: Only start counting if num is the START of a sequence[reference:28]
            // i.e., num - 1 does NOT exist in the set[reference:29]
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Step 4: Expand forward while consecutive numbers exist[reference:30]
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Step 5: Update the global maximum[reference:31]
                longest = Math.max(longest, currentLength);
            }
        }

        // Step 6: Return the longest sequence length[reference:32]
        return longest;
    }
}
