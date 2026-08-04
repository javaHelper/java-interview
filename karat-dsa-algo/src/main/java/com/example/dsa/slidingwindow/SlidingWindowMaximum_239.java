package com.example.dsa.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // The result array will have length n - k + 1
        int[] output = new int[nums.length - k + 1];
        int left = 0;

        // Deque to store indices of potential maximums
        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < nums.length; right++) {
            // 1. Remove indices that are out of the current window
            //    The window is [right - k + 1, right]
            if (!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // 2. Maintain decreasing order in the deque
            //    Remove from the back all indices whose values are less than
            //    or equal to the current element, as they can never be the max.
            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // 3. Add the current element's index to the deque
            deque.offer(right);

            // 4. Once we have processed the first k elements (window is full),
            //    the front of the deque is the maximum of the current window.
            if (right >= k - 1) {
                output[left++] = nums[deque.peekFirst()];
            }
        }

        return output;
    }


    static void main() {
        SlidingWindowMaximum_239 x = new SlidingWindowMaximum_239();
        System.out.println(Arrays.toString(x.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(x.maxSlidingWindow(new int[]{1}, 1)));
    }
}
