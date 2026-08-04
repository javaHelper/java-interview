package com.example.dsa.geeksforgeeks.string;

import java.util.ArrayList;

public class RotateBits {
    ArrayList<Integer> rotate(int n, int d) {
        // Reduce d to the effective rotation (0–15)
        d = d % 16;

        // Left rotation: shift left, bring overflowed bits to the right
        int left = (n << d) | (n >> (16 - d));
        left = left & 0xFFFF;  // keep only 16 bits

        // Right rotation: shift right, bring overflowed bits to the left
        int right = (n >> d) | (n << (16 - d));
        right = right & 0xFFFF;

        // Store results in an ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        result.add(left);
        result.add(right);
        return result;
    }

    static void main() {
        RotateBits sol = new RotateBits();

        // Test case 1: n = 28, d = 2 → expected [112, 7]
        System.out.println(sol.rotate(28, 2)); // [112, 7]

        // Test case 2: n = 29, d = 2 → expected [116, 16391]
        System.out.println(sol.rotate(29, 2)); // [116, 16391]

        // Test case 3: n = 11, d = 10 → expected [11264, 704]
        System.out.println(sol.rotate(11, 10)); // [11264, 704]

        // Test case 4: n = 1, d = 1 → expected [2, 32768]
        System.out.println(sol.rotate(1, 1)); // [2, 32768]
    }
}
