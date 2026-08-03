package com.example.array;

import java.util.Arrays;

public class RemoveDuplicatesSortedArray_26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    static void main() {
        // Example 1: [1,1,2] → 2, nums = [1,2,_]
        int[] nums1 = {1, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        int k1 = removeDuplicates(nums1);
        System.out.println("Output: " + k1 + ", nums = " + Arrays.toString(nums1));
        System.out.println();

        // Example 2: [0,0,1,1,1,2,2,3,3,4] → 5, nums = [0,1,2,3,4,_,_,_,_,_]
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums2));
        int k2 = removeDuplicates(nums2);
        System.out.println("Output: " + k2 + ", nums = " + Arrays.toString(nums2));
        System.out.println();
    }
}
