package com.example.twopointers;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArrayII_80Test {
    RemoveDuplicatesFromSortedArrayII_80 sol = new RemoveDuplicatesFromSortedArrayII_80();

    @Test
    void RemoveDuplicatesFromSortedArrayII_1(){
        // Example 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = sol.removeDuplicates(nums1);
        System.out.print("k = " + k1 + ", nums = [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 5, nums = [1, 1, 2, 2, 3]
    }

    @Test
    void RemoveDuplicatesFromSortedArrayII_2(){
        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = sol.removeDuplicates(nums2);
        System.out.print("k = " + k2 + ", nums = [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 7, nums = [0, 0, 1, 1, 2, 3, 3]
    }

    @Test
    void RemoveDuplicatesFromSortedArrayII_3(){
        // Edge case: all elements the same
        int[] nums3 = {2, 2, 2, 2};
        int k3 = sol.removeDuplicates(nums3);
        System.out.print("k = " + k3 + ", nums = [");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i] + (i < k3 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 2, nums = [2, 2]
    }


    @Test
    void RemoveDuplicatesFromSortedArrayII_4(){
        // Edge case: array with 1 element
        int[] nums4 = {5};
        int k4 = sol.removeDuplicates(nums4);
        System.out.print("k = " + k4 + ", nums = [");
        for (int i = 0; i < k4; i++) {
            System.out.print(nums4[i] + (i < k4 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 1, nums = [5]
    }
}
