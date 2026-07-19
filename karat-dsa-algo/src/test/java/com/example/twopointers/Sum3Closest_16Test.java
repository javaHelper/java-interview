package com.example.twopointers;

import org.junit.jupiter.api.Test;

public class Sum3Closest_16Test {
    Sum3Closest_16 sol = new Sum3Closest_16();

    @Test
    void Sum3Closest1(){
        // Example 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("Closest sum: " + sol.threeSumClosest(nums1, target1));
        // Expected: 2
    }

    @Test
    void Sum3Closest2(){
        // Example 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("Closest sum: " + sol.threeSumClosest(nums2, target2));
        // Expected: 0
    }

    @Test
    void Sum3Closest3(){
        // Additional test
        int[] nums3 = {1, 1, 1, 0};
        int target3 = -100;
        System.out.println("Closest sum: " + sol.threeSumClosest(nums3, target3));
        // Expected: 2 (sum of three smallest elements)
    }

    @Test
    void Sum3Closest4(){
        // Additional test (from LeetCode)
        int[] nums4 = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        int target4 = -2;
        System.out.println("Closest sum: " + sol.threeSumClosest(nums4, target4));
        // Expected: -2
    }
}
