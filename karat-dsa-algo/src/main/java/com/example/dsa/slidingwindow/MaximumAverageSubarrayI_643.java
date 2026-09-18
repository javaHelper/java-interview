package com.example.dsa.slidingwindow;

public class MaximumAverageSubarrayI_643 {

    /*
        Time	O(n) — single pass over the array
        Space	O(1) — only a few integer variables


        Step	Window	               Window Sum	    Max Sum
        1	    [1, 12, -5, -6]	          2	            2
        2	    [12, -5, -6, 50]	      51	        51
        3	    [-5, -6, 50, 3]	          42	        51

     */

    public double findMaxAverage(int[] nums, int k) {
        // Step 1: Compute sum of the first k elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum = windowSum + nums[i];
        }

        int maxSum = windowSum;

        // Step 2: Slide the window and track the maximum sum
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum / k;
    }

    static void main() {
        MaximumAverageSubarrayI_643 x = new MaximumAverageSubarrayI_643();
        System.out.println(x.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
