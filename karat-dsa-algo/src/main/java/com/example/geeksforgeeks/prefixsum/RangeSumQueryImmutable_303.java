package com.example.geeksforgeeks.prefixsum;

public class RangeSumQueryImmutable_303 {
    private int[] prefixSum;

    // Constructor: Build the prefix sum array
    public RangeSumQueryImmutable_303(int[] nums) {
        int n = nums.length;
        // Create an array of size n+1, where prefixSum[i] stores the sum of nums[0..i-1]
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            // The sum of the first (i+1) elements is the sum of the first i elements + nums[i]
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // Query: Return the sum of elements between indices left and right (inclusive)
    public int sumRange(int left, int right) {
        // The sum of nums[left..right] is the sum of nums[0..right] minus the sum of nums[0..left-1]
        return prefixSum[right + 1] - prefixSum[left];
    }
}
