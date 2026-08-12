package com.example.geeksforgeeks.array;

import java.util.Arrays;

/*
    The modulo operation (% MOD) at each step keeps the number small, preventing overflow,

    Why is MOD Needed?
        Let's look at the numbers. The problem asks us to calculate the maximum sum of arr[i] * i after sorting the array.
        If we just use a regular int, we could hit a limit very quickly. Consider the worst-case scenario for this problem:

        Array size (n) = 10^5
        Each element (arr[i]) = 10^5

        The maximum possible sum would be:
        0*0 + 1*1 + 2*2 + ... which is approximately n * max_element * n, or 10^5 * 10^5 * 10^5 = 10^15.

        This number is 1,000,000,000,000,000 (one quadrillion). It's far beyond the maximum value a 32-bit integer can hold (2,147,483,647).
        Even a 64-bit long (max ~9.22e18) can handle 1e15, but to be safe for all possible constraints, the problem expects the answer modulo 10^9+7

 */
public class MaxValuePermutation {

    public int maxValue(int[] arr) {
        int MOD = 1_000_000_007;
        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = (sum + (long) arr[i] * i) % MOD;
        }
        return (int) sum;
    }

    static void main() {
        MaxValuePermutation x = new MaxValuePermutation();
        System.out.println(x.maxValue(new int[]{5, 3, 2, 4, 1}));
        System.out.println(x.maxValue(new int[]{1, 2, 3}));
    }
}
