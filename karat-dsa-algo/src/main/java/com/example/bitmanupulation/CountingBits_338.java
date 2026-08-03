package com.example.bitmanupulation;

import java.util.Arrays;

public class CountingBits_338 {

    /**
     * Dynamic Programming – Least Significant Bit (O(n))
     * -----------------------------------------------------
     * This is the most elegant and widely used solution. The key observation: for any number i,
     * the number of 1s in i equals the number of 1s in i >> 1 (which removes the last bit) plus the
     * last bit itself (i & 1)
     * <p>
     * dp[i] = dp[i >> 1] + (i & 1)
     * <p>
     * Where:
     * <p>
     * i >> 1 removes the last binary digit (equivalent to i / 2)
     * i & 1 returns:
     * 1 if i is odd (last bit is 1)
     * 0 if i is even (last bit is 0)
     * <p>
     * How it works (example for i = 5):
     * <p>
     * 5 in binary is 101
     * i >> 1 = 2 (binary 10), which has 1 one-bit.
     * i & 1 = 1 (last bit is 1).
     * So dp[5] = dp[2] + 1 = 1 + 1 = 2 ✓
     * <p>
     * <p>
     * Time: O(n) – single pass.
     * Space: O(n) for the dp array
     *
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);  // i >> 1 is i/2, i & 1 is last bit
        }
        return result;
    }

    static void main(String[] args) {
        CountingBits_338 x = new CountingBits_338();
        System.out.println(Arrays.toString(x.countBits(2)));
        System.out.println(Arrays.toString(x.countBits(5)));
    }
}
