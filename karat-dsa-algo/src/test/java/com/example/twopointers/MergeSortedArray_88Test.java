package com.example.twopointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortedArray_88Test {
    MergeSortedArray_88 sol = new MergeSortedArray_88();

    @Test
    void MergeSortedArray1(){
        // Example 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        sol.merge(nums1, 3, nums2, 3);
        System.out.print("Output: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: 1 2 2 3 5 6
    }

    @Test
    void MergeSortedArray2(){
        // Example 2
        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        sol.merge(nums1_2, 1, nums2_2, 0);
        System.out.print("Output: ");
        for (int num : nums1_2) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: 1
    }

    @Test
    void MergeSortedArray3(){
        // Additional test: nums2 has smaller elements
        int[] nums1_3 = {4, 5, 6, 0, 0, 0};
        int[] nums2_3 = {1, 2, 3};
        sol.merge(nums1_3, 3, nums2_3, 3);
        System.out.print("Output: ");
        for (int num : nums1_3) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: 1 2 3 4 5 6
    }

    @Test
    void MergeSortedArray4(){
        // Additional test: nums1 has all smaller elements
        int[] nums1_4 = {1, 2, 3, 0, 0, 0};
        int[] nums2_4 = {4, 5, 6};
        sol.merge(nums1_4, 3, nums2_4, 3);
        System.out.print("Output: ");
        for (int num : nums1_4) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: 1 2 3 4 5 6
    }
}
