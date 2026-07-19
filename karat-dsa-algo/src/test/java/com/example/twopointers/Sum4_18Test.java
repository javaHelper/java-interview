package com.example.twopointers;

import org.junit.jupiter.api.Test;

public class Sum4_18Test {
    Sum4_18 sol = new Sum4_18();

    @Test
    void Sum4_1(){
        // Example 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        System.out.println("Output: " + sol.fourSum(nums1, 0));
        // Expected: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }

    @Test
    void Sum4_2(){
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("Output: " + sol.fourSum(nums2, 8));
        // Expected: [[2, 2, 2, 2]]
    }

    @Test
    void Sum4_3(){
        // Additional test
        int[] nums3 = {-2, -1, 0, 0, 1, 2};
        System.out.println("Output: " + sol.fourSum(nums3, 0));
        // Expected: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }
}
