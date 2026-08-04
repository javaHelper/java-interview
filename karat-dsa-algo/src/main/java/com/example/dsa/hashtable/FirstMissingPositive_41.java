package com.example.dsa.hashtable;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number at its correct index using cyclic sort
        int i = 0;
        while (i < n) {
            // Check if nums[i] is in the valid range [1, n]
            // AND nums[i] is not already at its correct position
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with the element at its target index
                int targetIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
            } else {
                // Move to the next index
                i++;
            }
        }

        // Step 2: Find the first missing positive
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: All numbers 1 to n are present
        return n + 1;
    }
}
