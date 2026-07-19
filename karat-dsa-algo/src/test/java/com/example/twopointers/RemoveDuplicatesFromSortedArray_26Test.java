package com.example.twopointers;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArray_26Test {
    RemoveDuplicatesFromSortedArray_26 sol = new RemoveDuplicatesFromSortedArray_26();

    @Test
    void RemoveDuplicatesFromSortedArray1(){
        // Example 1
        int[] nums1 = {1, 1, 2};
        int k1 = sol.removeDuplicates(nums1);
        System.out.print("k = " + k1 + ", nums = [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 2, nums = [1, 2]
    }

    @Test
    void RemoveDuplicatesFromSortedArray2(){
        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = sol.removeDuplicates(nums2);
        System.out.print("k = " + k2 + ", nums = [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 5, nums = [0, 1, 2, 3, 4]
    }

    @Test
    void RemoveDuplicatesFromSortedArray3(){
        // Edge case: single element
        int[] nums3 = {5};
        int k3 = sol.removeDuplicates(nums3);
        System.out.print("k = " + k3 + ", nums = [");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i] + (i < k3 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 1, nums = [5]
    }

    @Test
    void RemoveDuplicatesFromSortedArray4(){
        // Edge case: all duplicates
        int[] nums4 = {2, 2, 2, 2};
        int k4 = sol.removeDuplicates(nums4);
        System.out.print("k = " + k4 + ", nums = [");
        for (int i = 0; i < k4; i++) {
            System.out.print(nums4[i] + (i < k4 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 1, nums = [2]
    }
}
