package com.example.dsa.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // First pass: answer[i] = product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Second pass: multiply by product of all elements to the right of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    static void main() {
        ProductOfArrayExceptSelf_238 sol = new ProductOfArrayExceptSelf_238();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = sol.productExceptSelf(nums1);
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1));
        // Expected: [24, 12, 8, 6]

        System.out.println();

        // Example 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = sol.productExceptSelf(nums2);
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));
        // Expected: [0, 0, 9, 0, 0]

        System.out.println();

        // Example 3: all zeros
        int[] nums3 = {0, 0};
        int[] result3 = sol.productExceptSelf(nums3);
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.toString(result3));
        // Expected: [0, 0]

        System.out.println();

        // Example 4: single element (edge case, though constraints usually n >= 2)
        // The problem guarantees n >= 2, but just for demonstration:
        int[] nums4 = {5};
        int[] result4 = sol.productExceptSelf(nums4);
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + Arrays.toString(result4));
        // For n=1, the product of all except itself is 1 (empty product)
        // But LeetCode constraints say n >= 2, so this is optional.
    }
}
