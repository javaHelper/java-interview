package com.example.geeksforgeeks.string;

/*
    A binary string can be made alternating in two ways:
        Pattern 1: starts with '0' → "010101..."
        Pattern 2: starts with '1' → "101010..."
    For each pattern, count the number of positions where the given string differs.
    The answer is the minimum of those two counts.

    However, the two patterns are complements of each other.
    If flips0 is the number of mismatches with the pattern starting with '0', then the mismatches
    with the pattern starting with '1' is simply n - flips0 (because each position either matches or not).
    So we only need to compute flips0 and then take min(flips0, n - flips0).
 */
public class MinNumberOfFlips {
    public static int minFlips(String s) {
        int flips0 = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expected) {
                flips0++;
            }
        }
        return Math.min(flips0, s.length() - flips0);
    }

    static void main() {
        System.out.println(minFlips("001"));
    }
}
