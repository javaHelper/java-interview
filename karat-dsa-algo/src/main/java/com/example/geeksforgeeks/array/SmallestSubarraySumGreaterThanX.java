package com.example.geeksforgeeks.array;

public class SmallestSubarraySumGreaterThanX {
    public int smallestSubWithSum(int x, int[] arr) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > x) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    static void main() {
        SmallestSubarraySumGreaterThanX x = new SmallestSubarraySumGreaterThanX();
        System.out.println(x.smallestSubWithSum(51, new int[]{1, 4, 45, 6, 0, 19}));
    }
}
