package com.example.twopointers;

import java.util.Arrays;

public class Sum3Closest_16 {

    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to enable two-pointer technique
        Arrays.sort(nums);

        // Initialize closest with the sum of the first three numbers
        int closest = nums[0] + nums[1] + nums[2];

        // Fix the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the fixed element to avoid redundant work
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If we find an exact match, we cannot get any closer – return immediately
                if (sum == target) {
                    return sum;
                }

                // Update closest if the current sum is closer to target
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                // Move pointers based on comparison with target
                if (sum < target) {
                    left++;   // Need a larger sum
                } else {
                    right--;  // Need a smaller sum
                }
            }
        }
        return closest;
    }
}
