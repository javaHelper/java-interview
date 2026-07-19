package com.example.twopointers;

import org.junit.jupiter.api.Test;

public class RemoveElement_27Test {
    RemoveElement_27 sol = new RemoveElement_27();

    @Test
    void RemoveElement1() {
        // Example 1
        int[] nums1 = {3, 2, 2, 3};
        int k1 = sol.removeElement(nums1, 3);
        System.out.print("k = " + k1 + ", nums = [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 2, nums = [2, 2]
    }

    @Test
    void RemoveElement2() {
        // Example 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int k2 = sol.removeElement(nums2, 2);
        System.out.print("k = " + k2 + ", nums = [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 5, nums = [0, 1, 4, 0, 3] (order may vary)
    }

    @Test
    void RemoveElement3() {
        int[] nums3 = {};
        int k3 = sol.removeElement(nums3, 0);
        System.out.println("k = " + k3 + ", nums = []");
        // Expected: k = 0
    }

    @Test
    void RemoveElement4() {
        // Edge case: all elements equal to val
        int[] nums4 = {2, 2, 2};
        int k4 = sol.removeElement(nums4, 2);
        System.out.print("k = " + k4 + ", nums = [");
        for (int i = 0; i < k4; i++) {
            System.out.print(nums4[i] + (i < k4 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Expected: k = 0
    }
}
