package com.example.geeksforgeeks.slidingwindow;

public class SmallestSubarraySumGreaterThanX {

    /*
        Given a number x and an array of integers arr, find the smallest subarray with sum strictly
        greater than the given value. If such a subarray do not exist return 0 in that case.

        x = 51
        arr = [1, 4, 45, 6, 0, 19]

        [1]                  sum = 1
        [1,4]                sum = 5
        [1,4,45]             sum = 50
        [1,4,45,6]           sum = 56  ← valid

        [4,45,6]             sum = 55  ← valid, length = 3
        [45,6]               sum = 51  ← NOT > 51


        Expand right
            ↓
        sum becomes > x
            ↓
        record answer
            ↓
        shrink left
            ↓
        sum becomes <= x
            ↓
        expand right again

        Why? Because after finding a valid window, we want to remove as many elements from the left as possible while keeping the window valid.
        That is what gives us the smallest window.
     */
    public static int smallestSubWithSum(int x, int[] arr) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum = sum + arr[right];

            while (sum > x) {
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    static void main() {
        System.out.println(smallestSubWithSum(51, new int[]{1, 4, 45, 6, 0, 19}));
    }
}
