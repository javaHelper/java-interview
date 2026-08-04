package com.example.dsa.array;

import java.util.Arrays;

public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If current number is negative, swapping max and min helps
            // because a negative number will turn a min into a max.
            if (num < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Update max and min ending at current position
            maxSoFar = Math.max(num, maxSoFar * num);
            minSoFar = Math.min(num, minSoFar * num);

            // Update overall result
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    static void main() {
        MaximumProductSubarray_152 sol = new MaximumProductSubarray_152();

        // Example 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Max Product: " + sol.maxProduct(nums1));
        // Expected: 6  (subarray [2,3])

        System.out.println();

        // Example 2
        int[] nums2 = {-2, 0, -1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Max Product: " + sol.maxProduct(nums2));
        // Expected: 0  (subarray [0] or empty? but subarray must be non-empty, so 0)

        System.out.println();

        // Example 3: all negative
        int[] nums3 = {-2, -3, -4};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Max Product: " + sol.maxProduct(nums3));
        // Expected: 12  (subarray [-2,-3,-4] = -2 * -3 * -4 = -24? Wait, 2*3=6, but 2*3*4=24? Actually -2 * -3 = 6, 6 * -4 = -24. But better subarray: [-2,-3] = 6, or [-3,-4]=12. So max is 12)
        // Let's compute: -2 * -3 * -4 = -24, -2 * -3 = 6, -3 * -4 = 12, so 12 is max.

        System.out.println();

        // Example 4: single element
        int[] nums4 = {5};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Max Product: " + sol.maxProduct(nums4));
        // Expected: 5

        System.out.println();

        // Example 5: mixed with zero
        int[] nums5 = {1, -2, 0, 3, -4, 5};
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Max Product: " + sol.maxProduct(nums5));
        // Expected: 60? Let's check: subarray [3,-4,5] = 3 * -4 * 5 = -60, but [3,-4] = -12, [-4,5] = -20, [3,-4,5] negative. Actually [1,-2,0] = 0, [0,3,-4,5] = 0? Better: [3] =3, [-4] = -4, [5]=5, [3,-4,5] = -60, [3,-4] = -12, [-4,5] = -20. Max is 5? But what about [1,-2] = -2, [1,-2,0,3,-4,5] = 0? Actually product of entire array = 1 * -2 * 0 * 3 * -4 * 5 = 0. So max seems 5. But algorithm will compute correctly.
        // Actually let's run: our algorithm will give 60? Let's think: maximum subarray product can be 5, or maybe 0? but 5 > 0. So 5.
        // But wait, subarray [3,-4,5] = -60, not good. [3,-4] = -12. [-4,5] = -20. So max is 5. So output 5.
        // I'll trust the algorithm.
    }
}
