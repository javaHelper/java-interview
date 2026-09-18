package com.example.dsa.slidingwindow;

public class NumberOfSubAarraysOfSizeK_1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int targetSum = threshold * k;

        // Sum of first k elements
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum = windowSum + arr[i];
        }

        int count = 0;
        if (windowSum >= targetSum) {
            count++;
        }

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];   // add new, remove old
            if (windowSum >= targetSum) {
                count++;
            }
        }
        return count;
    }

    static void main() {
        NumberOfSubAarraysOfSizeK_1343 x = new NumberOfSubAarraysOfSizeK_1343();
        System.out.println(x.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }
}
