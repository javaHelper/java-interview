package com.example.dsa.slidingwindow;

import java.util.HashMap;

public class MaximumSumOfDistinctSubarraysWithLengthK_2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        long maxSum = 0;
        long windowSum = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        int distinct = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add nums[i] to the window
            int rightVal = nums[i];
            freq.put(rightVal, freq.getOrDefault(rightVal, 0) + 1);
            if (freq.get(rightVal) == 1) distinct++;
            windowSum += rightVal;

            // If the window exceeds size k, remove the leftmost element
            if (i >= k) {
                int leftVal = nums[i - k];
                freq.put(leftVal, freq.get(leftVal) - 1);
                if (freq.get(leftVal) == 0) distinct--;
                windowSum -= leftVal;
            }

            // If the window size is exactly k and all elements are distinct
            if (i >= k - 1 && distinct == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }

    static void main() {
        MaximumSumOfDistinctSubarraysWithLengthK_2461 x = new MaximumSumOfDistinctSubarraysWithLengthK_2461();
        System.out.println(x.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }
}
