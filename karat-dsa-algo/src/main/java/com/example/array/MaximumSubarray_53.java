package com.example.array;

public class MaximumSubarray_53 {

    /**
     * Kadane's Algorithm (Optimal)
     *Time Complexity: O(n) | Space Complexity: O(1)
     *
     * Intuition:
     * A brute‑force approach would generate all possible subarrays and calculate their sums, resulting
     * in O(n²) time. Instead, we observe that if the current subarray sum becomes negative, it can
     * never help increase the sum of any future subarray – so we discard it and start a new subarray
     * from the next element.
     *
     * Step‑by‑Step Explanation
     * 1. Initialize two variables:
     * maxSum = nums[0] – stores the maximum subarray sum found so far.
     * currentSum = 0 – tracks the sum of the current subarray we are building.
     *
     * 2. Iterate through the array from left to right:
     * Add the current element to currentSum.
     * If currentSum is greater than maxSum, update maxSum.
     * If currentSum becomes negative, reset it to 0 – because carrying a negative sum forward will only reduce future sums.
     *
     * 3.   After the loop, return maxSum.
     *
     * Dry Run
     * For nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]:
     *
     * Step	    Element	currentSum(before reset)	maxSum	Action
     * 1	   -2	    -2	                        -2	    reset to 0
     * 2	    1	    1	                        1	    keep
     * 3	    -3	    -2	                        1	    reset to 0
     * 4	    4	    4	                        4	    keep
     * 5	    -1	    3	                        4	    keep
     * 6	    2	    5	                        5	    keep
     * 7	    1	    6	                        6	    keep
     * 8	    -5	    1	                        6	    keep
     * 9	    4	    5	                        6	    keep
     */

    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum = currentSum + nums[i];
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }
        }
        return maxSoFar;
    }

    static void main() {
        MaximumSubarray_53 x = new MaximumSubarray_53();
        System.out.println(x.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
