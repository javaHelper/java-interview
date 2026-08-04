package com.example.dsa.tree.binarysearchtree;

public class FirstBadVersion_278 {
    // Change this value to test different cases
    private static int FIRST_BAD_VERSION = 4;

    // Simulates the LeetCode API
    public static boolean isBadVersion(int version) {
        return version >= FIRST_BAD_VERSION;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            // Prevent integer overflow
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // First bad version could be mid itself
                right = mid;
            } else {
                // First bad version must be after mid
                left = mid + 1;
            }
        }
        return left;
    }

    static void main() {
        FirstBadVersion_278 x = new FirstBadVersion_278();
        System.out.println(x.firstBadVersion(10));
    }
}
