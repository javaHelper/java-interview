package com.example.dsa.array;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If any elements left in nums2, copy them
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    static void main() {
        MergeSortedArray_88 sol = new MergeSortedArray_88();
        // Example test case
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        sol.merge(nums1, m, nums2, n);

        // Print the merged array
        System.out.println(Arrays.toString(nums1));
        // Expected output: [1, 2, 2, 3, 5, 6]


        // Additional test: one array empty
        int[] nums1b = {0};
        int m2 = 0;
        int[] nums2b = {1};
        int n2 = 1;
        sol.merge(nums1b, m2, nums2b, n2);
        System.out.println(Arrays.toString(nums1b)); // [1]

        // Additional test: nums2 empty
        int[] nums1c = {1};
        int m3 = 1;
        int[] nums2c = {};
        int n3 = 0;
        sol.merge(nums1c, m3, nums2c, n3);
        System.out.println(Arrays.toString(nums1c)); // [1]

        // Additional test: duplicates
        int[] nums1d = {2, 0};
        int m4 = 1;
        int[] nums2d = {1};
        int n4 = 1;
        sol.merge(nums1d, m4, nums2d, n4);
        System.out.println(Arrays.toString(nums1d)); // [1, 2]
    }
}
