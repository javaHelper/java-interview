package com.example.geeksforgeeks;

/**
 * Given an integer array arr[], return the sum of Hamming distances between all the pairs of the integers in arr.
 * <p>
 * Note: The answer is guaranteed to fit within a 32-bit integer.
 */
public class TotalHammingDistance {
    public int totHammingDist(int[] arr) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            int mask = 1 << i;

            // Count how many numbers have this bit set
            for (int num : arr) {
                if ((num & mask) != 0) {
                    ones++;
                }
            }
            // Pairs that differ at this bit = ones * (n - ones)
            total = total + ones * (arr.length - ones);
        }
        return total;
    }

    static void main() {
        TotalHammingDistance t = new TotalHammingDistance();
        System.out.println(t.totHammingDist(new int[]{1, 14}));
        System.out.println(t.totHammingDist(new int[]{4, 14, 4, 14}));
    }
}
