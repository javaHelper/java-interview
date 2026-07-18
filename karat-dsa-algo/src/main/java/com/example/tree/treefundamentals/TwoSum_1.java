package com.example.tree.treefundamentals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];

            // Check if the complement is already in the map
            if (seen.containsKey(x)) {
                // Found the pair: complement index (stored) and current index (i)
                return new int[]{seen.get(x), i};
            }

            // Store the current number and its index for future lookups
            seen.put(nums[i], i);
        }
        // Should never reach here per problem constraints
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum_1 twoSum = new TwoSum_1();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9))); // Output: [0, 1]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 2, 4}, 6))); // Output: [1, 2]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 3}, 6))); // Output: [0, 1]   '
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1, 2, 3, 4, 5}, 9))); // Output: [3, 4]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{-1, -2, -3, -4, -5}, -8))); // Output: [2, 4]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{0, 4, 3, 0}, 0))); // Output: [0, 3]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1, 5, 3, 7}, 10))); // Output: [1, 3]
    }
}
